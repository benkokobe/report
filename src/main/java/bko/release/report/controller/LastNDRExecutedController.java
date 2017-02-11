package bko.release.report.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcraft.jsch.JSchException;

import bko.release.report.domain.ReleaseDR;
import bko.release.report.service.DeploymentRequestService;
import bko.release.report.util.ReleaseCheckerManager;
import bko.release.report.util.ReleaseManager;
import bko.release.report.util.SynergyShellReleaseReport;

@Controller
@RequestMapping(value = "/last_ndr")
public class LastNDRExecutedController  extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(LastNDRExecutedController.class);
	@Resource
	private DeploymentRequestService deploymentRequestService;
	
	protected ReleaseCheckerManager releaseCheckManager;
	protected SynergyShellReleaseReport checkerShell;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) throws JSchException, IOException {
		super.initialize_release();
		
		model.addAttribute("releaseManager", this.releaseManager);
		model.addAttribute("env_name", env_name);
		
		
		logger.info("env_name:" + env_name);
		return "release-content-1";
		
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String submitForm(@ModelAttribute("releaseManager") ReleaseManager releaseManager,
//			BindingResult result, Model model) throws JSchException, IOException {
//
//		int lastN = 5;//FIXME
//		initialize();
//		//super.releaseManager.initialize(drName, shell, deploymentRequestService);
//		
//		model.addAttribute("env_name", env_name);
//		model.addAttribute("releaseCheckManager", this.releaseCheckManager);
//		
//		List<String> lastNDR= getLastNDrExecuted(lastN);
//		
//		model.addAttribute("lastNDrExecuted",lastNDR);
//		
//		this.releaseCheckManager.initialize_checker(lastDR, this.checkerShell);
//		
//		ReleaseDR releaseDr = this.releaseCheckManager.getReleaseDR();
//		releaseCheckManager.setReleaseDR(releaseDr);
//		
//		logger.info("env_name:" + env_name);
//		return "release-checker-1";
//	}
	
	public void initialize() throws JSchException {

		this.releaseCheckManager = new ReleaseCheckerManager();
		this.checkerShell = new SynergyShellReleaseReport();

		if (this.host_password.length() != 0)
			this.checkerShell.intialize_and_connect(host_name, host_login, host_password);
		else
			this.checkerShell.intialize_and_connect(host_name, host_login, ssh_key_file, ssh_key_pass);
	}
	
	public List<String> getLastNDrExecuted(int lastN){
		
		List<String> lastNDrExecuted = deploymentRequestService.getLastNDrExecuted(lastN);
		
		return lastNDrExecuted;
	}

}
