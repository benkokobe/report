package bko.release.report.domain;

import java.util.List;

public class ReleasePatch {
	private String patchRefence;
	private List<String> listOfDR;
	private List<String> listOfDestinationEnv;
	
	/*
	 * getters and setters
	 */
	public String getPatchRefence() {
		return patchRefence;
	}
	public void setPatchRefence(String patchRefence) {
		this.patchRefence = patchRefence;
	}
	public List<String> getListOfDR() {
		return listOfDR;
	}
	public void setListOfDR(List<String> listOfDR) {
		this.listOfDR = listOfDR;
	}
	public List<String> getListOfDestinationEnv() {
		return listOfDestinationEnv;
	}
	public void setListOfDestinationEnv(List<String> listOfDestinationEnv) {
		this.listOfDestinationEnv = listOfDestinationEnv;
	}
	

}