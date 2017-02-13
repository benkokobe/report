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

import com.jcraft.jsch.JSchException;

import bko.release.report.domain.ReleaseDR;
import bko.release.report.service.DeploymentRequestService;
import bko.release.report.util.ReleaseCheckerManager;
import bko.release.report.util.ReleaseManager;
import bko.release.report.util.SynergyShell;
import bko.release.report.util.SynergyShellReleaseReport;

@Controller
@RequestMapping(value = "/last_dr_executed")
public class ReleaseDRCheckerController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ReleaseDRCheckerController.class);
	
	@Resource
	private DeploymentRequestService deploymentRequestService;
	
	protected ReleaseCheckerManager releaseCheckManager;
	protected SynergyShellReleaseReport checkerShell;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) throws JSchException, IOException {
		initialize();
		//super.releaseManager.initialize(drName, shell, deploymentRequestService);
		
		model.addAttribute("env_name", env_name);
		model.addAttribute("releaseCheckManager", this.releaseCheckManager);
		
		String lastDR= getLastDrExecuted();
		
		model.addAttribute("lastDrExecuted",lastDR);
		
		if (this.checkerShell.checkSynergySession() != 0){
			logger.error("Please start the Synergy session of the user: " + host_login);
			model.addAttribute("host_login",host_login);
			return "synergy-error-page";
			
		}
		
		this.releaseCheckManager.initialize_checker(lastDR, this.checkerShell);
		
		ReleaseDR releaseDr = this.releaseCheckManager.getReleaseDR();
		releaseCheckManager.setReleaseDR(releaseDr);
		
		logger.info("env_name:" + env_name);
		return "release-checker-1";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("releaseCheckManager") ReleaseCheckerManager releaseCheckManager,
			BindingResult result, Model model) throws JSchException, IOException {

		logger.info("[ 1] submitForm: ");
		String drName= releaseCheckManager.getReleaseName();
		//SynergyShellReleaseReport checkerShell = (SynergyShellReleaseReport) shell;
		//releaseCheckManager.setSynergyShell(shell);
		this.releaseCheckManager.initialize_checker(drName, this.checkerShell);
		logger.info("[ 2] submitForm: ");
		
		//this.releaseCheckManager = releaseCheckManager;//assigned the sub class
		ReleaseDR releaseDr = this.releaseCheckManager.getReleaseDR();
		logger.info("[ 3] submitForm: ");
		releaseCheckManager.setReleaseDR(releaseDr);
		logger.info("[ 4] submitForm: ");
		// for JSP
		model.addAttribute("env_name", env_name);
		model.addAttribute("lastDrExecuted",drName);

		logger.info("Release destinations: " + this.releaseCheckManager.getReleaseDR().getListOfDestinations());
		logger.info("[ 5] submitForm: ");
		//this.releaseCheckManager.closeSession();

		return "release-checker-2";
	}
	
	/*
	 * special initializer
	 */
	public void initialize() throws JSchException {

		this.releaseCheckManager = new ReleaseCheckerManager();
		this.checkerShell = new SynergyShellReleaseReport();

		if (this.host_password.length() != 0)
			this.checkerShell.intialize_and_connect(host_name, host_login, host_password);
		else
			this.checkerShell.intialize_and_connect(host_name, host_login, ssh_key_file, ssh_key_pass);
	}
	
	public String getLastDrExecuted(){
		
		String lastDrExecuted = deploymentRequestService.getLastDrExecuted();
		
		return lastDrExecuted;
	}
}
