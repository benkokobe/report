package bko.release.report.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSchException;

import bko.release.report.controller.AboutController;
import bko.release.report.domain.ReleaseDR;
import bko.release.report.domain.ReleasePatch;

public class SynergyShellReleaseReport extends SynergyShell {
	
	private static final Logger logger = LoggerFactory.getLogger(SynergyShellReleaseReport.class);
	
	private ReleaseDR releaseDR;
	
	
	public ReleaseDR getReleaseDR() {
		return releaseDR;
	}

	public void setReleaseDR(ReleaseDR releaseDR) {
		this.releaseDR = releaseDR;
	}

	public List<ReleasePatch> getListOfPatches(String drName) throws JSchException, IOException{
		
		List<ReleasePatch> patchList = new ArrayList<ReleasePatch>();
		String query = "ccm query \"problem_type='patch' and is_associated_patch_of(dr_name = '"
				+ drName
				+ "'"
				+ ")\" "
				+ "-u -f \"%reference\"";
		
		sessionConnectAndExecCommand(query);
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(channel_exec.getInputStream()));
		
	    String line;
	    ReleasePatch releasePatch;
	    while ((line = reader.readLine()) != null) {
	    	releasePatch = new ReleasePatch();
	    	logger.info("getListOfPatches:-->" + line);
	    	releasePatch.setPatchRefence(line);
	    	patchList.add(releasePatch);
	    }
	    
		return patchList;
	}
	
	public ReleasePatch getFullPatchInformation(String patchReference) throws IOException, JSchException{
		String query = "ccm query \"(cvtype='problem') and problem_type = 'dr' and crstatus != 'dr_cancelled' and has_associated_patch (reference = '"
				+ patchReference
				+ "'"
				+ ")\" "
				+ "-u -f \"%dr_name | %destination_environment\"";
		
		sessionConnectAndExecCommand(query);
		BufferedReader reader = new BufferedReader(new InputStreamReader(channel_exec.getInputStream()));
		
		String line;
	    ReleasePatch releasePatch = new ReleasePatch();
	    
	    List<String> listOfDrs = new ArrayList<String>();
	    List<String> listOfDestEnv = new ArrayList<String>();
	    
	    releasePatch.setPatchRefence(patchReference);
	    
	    
	    while ((line = reader.readLine()) != null) {
	    	String[] tokens = line.split("\\|");
	    	logger.info(("token: "+ tokens.toString()));
	    	listOfDrs.add(tokens[0]);
	    	listOfDestEnv.add(tokens[1]);
	    }
    	releasePatch.setListOfDR(listOfDrs);
    	releasePatch.setListOfDestinationEnv(listOfDestEnv);
    	
    	return releasePatch;
    	
		
	}
	
	public void fillReleaseDR(String drName) throws JSchException, IOException{
		
		this.releaseDR = new ReleaseDR();
		this.releaseDR.setDrName(drName);
		
		List<ReleasePatch> patchList = new ArrayList<ReleasePatch>();
		List<ReleasePatch> patchListFull = new ArrayList<ReleasePatch>();
		
		ReleasePatch fullPatch;
		logger.info("[ 4] calling getListOfPatches: ");
		patchList = this.getListOfPatches(drName);
		
		for (ReleasePatch patch:patchList){
			fullPatch = getFullPatchInformation(patch.getPatchRefence());
			patchListFull.add(fullPatch);
		}
		
		this.releaseDR.setReleasePatchList(patchListFull);
		
	}
	
	public boolean sanity_check(){
		
		boolean status = true;
		List<ReleasePatch> patchList = this.releaseDR.getReleasePatchList();
		
		ReleasePatch patch = patchList.get(0);
		int nmbOfDestinations = patch.getListOfDestinationEnv().size(); // control number of destinations
		
		List<String> listOfDestinations = patch.getListOfDestinationEnv(); // control list of destinations
		
		//remove duplicates
		//listOfDestinations = listOfDestinations.stream().distinct().collect(Collectors.toList());//Java 8
		
		//remove duplicate work-around if Java 8 not used.
		Set<String> hs = new HashSet<>();
		hs.addAll(listOfDestinations);
		listOfDestinations.clear();
		listOfDestinations.addAll(hs);
		
		//System.out.println("Size of the control list:" + nmbOfDestinations);
		
		for ( ReleasePatch p: patchList){
			System.out.println("Patch " + p.getPatchRefence() + "installed in " + p.getListOfDestinationEnv().toString() + " environemnts");
			System.out.println("nmbOfDestinations: " + nmbOfDestinations);
			if (p.getListOfDestinationEnv().size() != nmbOfDestinations){
				System.out.println("Patch " + p.getPatchRefence() + " not on all destinations");
				//status = false; FIXME --> why was it there in the first place.
			}
		}
		if (status){
			this.releaseDR.setListOfDestinations(listOfDestinations);
			logger.info("Package is OK");
			logger.info("DR: " + this.releaseDR.getDrName() + " installed on :" + this.releaseDR.getListOfDestinations());
		}else{
			logger.error("Issue with package consistency: !!!");
			//FIXME --> why was it there in the first place.
		}
		return status;
	}
	
	//public static void main(String[] arg) throws IOException, JSchException {
	public void main(String[] arg) throws IOException, JSchException {
			
			
//			String query = "ccm query \"has_associated_dr(dr_name='"
//					+ "PACK-ACP-0011"
//					+ "'"
//					+ "\" "
//					+ "-u -f \"%dr_name";
			SynergyShellReleaseReport shell = new SynergyShellReleaseReport();
			String key = "C:\\thalerng\\config\\bko_priv_rsa.ppk";
			String pass = "bko";
			shell.intialize_and_connect("scm.com.saas.i2s", "bkokobe", key, pass);
			//shell.execute_command(query);
			String drName = "PACK-PRG-0071";
			List<ReleasePatch> patchList;
			//patchList = shell.getListOfPatches(drName);
			
			shell.fillReleaseDR(drName);
			
			ReleaseDR releaseDr = shell.getReleaseDR();
			
			patchList = releaseDr.getReleasePatchList();

			for (ReleasePatch patch: patchList){
				//logger.info("env_name:" + env_name);
				logger.info("Patch: "+ patch.getPatchRefence());
				logger.info("DR: " + patch.getListOfDR());
				logger.info("Destination: "+ patch.getListOfDestinationEnv());
			}
			shell.sanity_check();
//			if (shell.sanity_check()){
//				logger.info("Package is OK");
//				logger.info("DR: " + releaseDr.getDrName() + " installed on :" + releaseDr.getListOfDestinations());
//			}
			
//			for (ReleasePatch patch: patchList){
//				System.out.println("Patch: " + patch.getPatchRefence());
//				//ReleasePatch patchFull = shell.getFullPatchInformation(patch.getPatchRefence());
////				System.out.println("DR: "+ patchFull.getListOfDR());
////				System.out.println("Destination: "+ patchFull.getListOfDestinationEnv());
//			}
			
			//shell.execute_query_patch_list(drName);
			
			
		}
}
