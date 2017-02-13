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
import bko.release.report.util.LastNDRExecutedManager;
import bko.release.report.util.ReleaseCheckerManager;
import bko.release.report.util.ReleaseManager;
import bko.release.report.util.SynergyShellReleaseReport;

@Controller
@RequestMapping(value = "/last_ndr_executed")
public class LastNDRExecutedController  extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(LastNDRExecutedController.class);
	@Resource
	private DeploymentRequestService deploymentRequestService;
	
	protected LastNDRExecutedManager lastNDRExecuted;
	protected SynergyShellReleaseReport checkerShell;
	protected List <String> listOfLastNDRExecuted;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) throws JSchException, IOException {
		
		initialize();
		//super.initialize_release();
		
		//FIXME: hadcoded value
		int lastN = 5;
		
		this.listOfLastNDRExecuted = getLastNDrExecuted(lastN);
		
		if (this.checkerShell.checkSynergySession() != 0){
			logger.error("Please start the Synergy session of the user: " + host_login);
			model.addAttribute("host_login",host_login);
			return "synergy-error-page";
			
		}
		
		model.addAttribute("env_name", env_name);
		model.addAttribute("listOfLastNDRExecuted",listOfLastNDRExecuted);
		
		logger.info("env_name:" + env_name);
		return "last_ndr_executed";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("lastNDRExecuted") LastNDRExecutedManager lastNDRExecuted,
			BindingResult result, Model model) throws JSchException, IOException {

		logger.info("[ 1] submitForm: lastNDRExecuted.initialize_checker(this.listOfLastNDRExecuted, this.checkerShell)");
		
		this.lastNDRExecuted.initialize_checker(this.listOfLastNDRExecuted, this.checkerShell);
		

		List<ReleaseDR> listOfDRExecuted = this.lastNDRExecuted.getListOfNDRexecuted();
		lastNDRExecuted.setListOfNDRexecuted(listOfDRExecuted);
		
		// for JSP
		model.addAttribute("env_name", env_name);
		model.addAttribute("listOfLastNDRExecuted",listOfLastNDRExecuted);
		model.addAttribute("lastNDRExecuted", this.lastNDRExecuted);
		


		return "last_ndr_executed-2";
	}
	
	public void initialize() throws JSchException {

		this.lastNDRExecuted = new LastNDRExecutedManager();
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
