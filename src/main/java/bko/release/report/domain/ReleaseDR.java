package bko.release.report.domain;

import java.util.List;

import org.springframework.stereotype.Component;

public class ReleaseDR {
	
	private String drName;
	private List<ReleasePatch> releasePatchList;
	private List<String> listOfDestinations;
	
	/*
	 * getters and setters
	 */
	public List<String> getListOfDestinations() {
		return listOfDestinations;
	}
	public void setListOfDestinations(List<String> listOfDestinations) {
		this.listOfDestinations = listOfDestinations;
	}
	public String getDrName() {
		return drName;
	}
	public void setDrName(String drName) {
		this.drName = drName;
	}
	public List<ReleasePatch> getReleasePatchList() {
		return releasePatchList;
	}
	public void setReleasePatchList(List<ReleasePatch> releasePatchList) {
		this.releasePatchList = releasePatchList;
	}
	
	
}
