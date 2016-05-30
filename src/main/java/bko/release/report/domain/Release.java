package bko.release.report.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Release {

private static final Logger log = LoggerFactory.getLogger(Release.class);
	
	private String releaseName;
	private List<DeploymentRequest> linkedDeploymentRequest;
	private boolean hasLinkedDr;
	private int numberOfLinkedDr;
	
	//setters/getters
	public String getReleaseName() {
		return releaseName;
	}
	public List<DeploymentRequest> getLinkedDeploymentRequest() {
		return linkedDeploymentRequest;
	}
	public void setLinkedDeploymentRequest(List<DeploymentRequest> linkedDeploymentRequest) {
		this.linkedDeploymentRequest = linkedDeploymentRequest;
	}
	public int getNumberOfLinkedDr() {
		return numberOfLinkedDr;
	}
	public void setNumberOfLinkedDr(int numberOfLinkedDr) {
		this.numberOfLinkedDr = numberOfLinkedDr;
	}
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}

}
