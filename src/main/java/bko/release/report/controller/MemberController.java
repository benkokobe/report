package bko.release.report.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcraft.jsch.JSchException;

import bko.release.report.domain.MyMemberDescription;
import bko.release.report.util.MyMemberDescriptionManager;
import bko.release.report.util.ReleaseManager;

@Controller
@RequestMapping(value = "/member")
public class MemberController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	MyMemberDescription myMemberDescription;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) throws JSchException, IOException {
		//super.initialize_release();
		//super.releaseManager.initialize(drName, shell, deploymentRequestService);
		
		myMemberDescription = new MyMemberDescription();
		
		model.addAttribute("member_description", this.myMemberDescription);
		//model.addAttribute("env_name", env_name);
		
		
		logger.info("using flattening library:");
		return "memberDescription-1";
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("member_description") MyMemberDescription memberDescription,
			BindingResult result, Model model) throws JSchException, IOException {

		//releaseManager.initialize(drName, shell, deploymentRequestService);
		
		MyMemberDescriptionManager myMemberManager = new MyMemberDescriptionManager();
		myMemberManager.setMember(memberDescription.getName(), memberDescription.getGroup(), memberDescription.getType(), 
				memberDescription.getCompanyId());
		
		myMemberManager.initialize_description();
		memberDescription.setMySqlQueries(myMemberManager.getMyMemberDescription().getMySqlQueries());
		//this.myMemberManager = memberDescription;
		
		
		// for JSP
		//model.addAttribute("env_name", env_name);

		//logger.info("Release synopsis: " + releaseManager.getSynopsisOfRelease());
		//this.releaseManager.closeSession();

		logger.info("calling : memberDescription-2");
		return "memberDescription-2";
	}
	

}
