package bko.release.report.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSchException;

import bko.release.report.domain.ReleaseDR;
import bko.release.report.domain.ReleasePatch;
import bko.release.report.service.DeploymentRequestService;

public class ReleaseCheckerManager extends ReleaseManager{
	private static final Logger log = LoggerFactory.getLogger(ReleaseCheckerManager.class);
	
	private ReleaseDR releaseDR;
	private SynergyShellReleaseReport synergyShell;
	
	/*
	 * getters and setters
	 */
	public ReleaseDR getReleaseDR() {
		return releaseDR;
	}
	public void setReleaseDR(ReleaseDR releaseDR) {
		this.releaseDR = releaseDR;
	}
	public SynergyShellReleaseReport getSynergyShell() {
		return synergyShell;
	}
	public void setSynergyShell(SynergyShellReleaseReport synergyShell) {
		this.synergyShell = synergyShell;
	}
//	public void initialize_checker(String drName) throws JSchException, IOException{
//		
//		this.releaseDR = new ReleaseDR();
//		this.releaseDR.setDrName(drName);
//		
//		this.synergyShell.fillReleaseDR(drName);
//		
//		List<ReleasePatch> releasePatchList = this.synergyShell.getListOfPatches(drName);
//		this.releaseDR.setReleasePatchList(releasePatchList);
//		
//		if (this.synergyShell.sanity_check()){
//			//List<String> listOfDestinations = this.releaseDR.getListOfDestinations();
//			log.info("Destination environments are consistent!!");
//		}else{
//			log.error("Please check the destination environments inconsistency!!");
//			//listOfDestinations = 
//		}
//		
//		
//	}
	//FIXME over-loaded ( to refactor)
	public void initialize_checker(String drName, SynergyShellReleaseReport shell) 
			throws JSchException, IOException{
		
		this.synergyShell = shell;
		this.releaseDR = new ReleaseDR();
		this.releaseDR.setDrName(drName);
		
		this.synergyShell.fillReleaseDR(drName);
		
		List<ReleasePatch> releasePatchList = this.synergyShell.getListOfPatches(drName);
		this.releaseDR.setReleasePatchList(releasePatchList);
		
		if (this.synergyShell.sanity_check()){
			//List<String> listOfDestinations = this.releaseDR.getListOfDestinations();
			log.info("Destination environments are consistent!!");
			
			List<String> listOfDestinations = this.synergyShell.getReleaseDR().getListOfDestinations();
			Collections.sort(listOfDestinations);
			this.releaseDR.setListOfDestinations(listOfDestinations );
			
		}else{
			log.error("Please check the destination environments inconsistency!!");
			//listOfDestinations = 
		}
		
	}
	public void closeSession(){
		this.synergyShell.getSession().disconnect();
	}
	
	

}
