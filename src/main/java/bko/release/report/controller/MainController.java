package bko.release.report.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcraft.jsch.JSchException;

import bko.release.report.service.DeploymentRequestService;
import bko.release.report.util.ReleaseManager;

@Controller
@RequestMapping(value = "/")
public class MainController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource
	private DeploymentRequestService deploymentRequestService;
	
	//@RequestMapping("/")
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) throws JSchException, IOException {
		super.initialize_release();
		//super.releaseManager.initialize(drName, shell, deploymentRequestService);
		
		model.addAttribute("releaseManager", this.releaseManager);
		model.addAttribute("env_name", env_name);
		
		if (this.shell.checkSynergySession() != 0){
			logger.error("Please start the Synergy session of the user: " + host_login);
			model.addAttribute("host_login",host_login);
			return "synergy-error-page";
			
		}
		
		
		logger.info("env_name:" + env_name);
		return "release-content-1";
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("releaseManager") ReleaseManager releaseManager,
			BindingResult result, Model model) throws JSchException, IOException {

		String drName= releaseManager.getReleaseName();
		releaseManager.initialize(drName, shell, deploymentRequestService);
		
		this.releaseManager = releaseManager;
		// for JSP
		model.addAttribute("env_name", env_name);

		logger.info("Release synopsis: " + releaseManager.getSynopsisOfRelease());
		this.releaseManager.closeSession();

		return "release-content-2";
	}
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String submitForm(@RequestParam(required = true, value = "releaseName") String releaseName, 
			Model model, RedirectAttributes redirctAttributes)
			throws JSchException, IOException {

		// for Excel sheet
		model.addAttribute("releaseManager", this.releaseManager);
		model.addAttribute("shell", this.shell);

		logger.info("To generate an excel document for release :" + releaseName);
		logger.info("Release synopsis                          :" + releaseManager.getSynopsisOfRelease());

		redirctAttributes.addFlashAttribute("flashkind", "success");
		redirctAttributes.addFlashAttribute("flashMessage",
				"Success: The file " + releaseName + ".xsl" + " is generated in your default download directory!");

		//return "redirect:/";
		return "release-content-3";
		
	}

}
