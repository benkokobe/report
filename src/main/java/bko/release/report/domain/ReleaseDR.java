package bko.release.report.domain;

import java.util.List;

import org.springframework.stereotype.Component;

public class ReleaseDR {
	
	private String drName;
	private String synopsis;
	
	private List<ReleasePatch> releasePatchList;
	private List<String> listOfDestinations;//FIXME: A DR has only one destination!!
	
	/*
	 * getters and setters
	 */
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
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
