package bko.release.report.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSchException;

import bko.release.report.domain.ReleaseDR;
import bko.release.report.domain.ReleasePatch;

public class LastNDRExecutedManager extends ReleaseManager {
	
private static final Logger log = LoggerFactory.getLogger(LastNDRExecutedManager.class);
	
	private List<ReleaseDR> listOfNDRexecuted;
	private SynergyShellReleaseReport synergyShell;
	
	
	public List<ReleaseDR> getListOfNDRexecuted() {
		return listOfNDRexecuted;
	}
	public void setListOfNDRexecuted(List<ReleaseDR> listOfNDRexecuted) {
		this.listOfNDRexecuted = listOfNDRexecuted;
	}
	public SynergyShellReleaseReport getSynergyShell() {
		return synergyShell;
	}
	public void setSynergyShell(SynergyShellReleaseReport synergyShell) {
		this.synergyShell = synergyShell;
	}
	
	
	public void initialize_checker(List<String> lastNDR, SynergyShellReleaseReport shell) 
			throws JSchException, IOException{
		
		this.synergyShell = shell;
		
		this.listOfNDRexecuted = new ArrayList<ReleaseDR>();
		
		ReleaseDR releaseDr;
		
		for ( String dr: lastNDR){
			releaseDr = new ReleaseDR();
			releaseDr.setDrName(dr);
			this.synergyShell.fillReleaseDR(dr);
			String synopsis = this.synergyShell.getDRSynopsis(dr);
			releaseDr.setSynopsis(synopsis);
			List<ReleasePatch> releasePatchList = this.synergyShell.getListOfPatches(dr);
			releaseDr.setReleasePatchList(releasePatchList);
			
			log.info("***************** DR to check: " + dr);
			
			if (this.synergyShell.sanity_check()){
				//List<String> listOfDestinations = this.releaseDR.getListOfDestinations();
				log.info("Destination environments are consistent!!");
				
				List<String> listOfDestinations = this.synergyShell.getReleaseDR().getListOfDestinations();
				Collections.sort(listOfDestinations);
				releaseDr.setListOfDestinations(listOfDestinations );
				
			}else{
				log.error("Please check the destination environments inconsistency!!");
				//listOfDestinations = 
			}
			listOfNDRexecuted.add(releaseDr);
		}
		
		
		
		
		
		
		
		
		
	}
	

}
