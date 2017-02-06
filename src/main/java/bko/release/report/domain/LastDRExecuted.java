package bko.release.report.domain;

public class LastDRExecuted extends ReleaseDR{
	private String drName;
	//private String synopsis;
	private String destinationEnvironment;
	
	/*
	 * getters and setters
	 */
	public String getDrName() {
		return drName;
	}
	public void setDrName(String drName) {
		this.drName = drName;
	}
	public String getDestinationEnvironment() {
		return destinationEnvironment;
	}
	public void setDestinationEnvironment(String destinationEnvironment) {
		this.destinationEnvironment = destinationEnvironment;
	}

}
