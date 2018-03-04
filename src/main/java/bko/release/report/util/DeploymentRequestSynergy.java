package bko.release.report.util;

import java.io.IOException;
import java.util.List;


import com.jcraft.jsch.JSchException;

import bko.release.report.domain.DeploymentRequest;
import bko.release.report.domain.Patch;
import bko.release.report.domain.SynergyObject;

public class DeploymentRequestSynergy {

	private DeploymentRequest deploymentRequest;

	private SynergyShell synergyShell;
	List<SynergyObject> synergyObjects;
	List<Patch> patchList;

	public void setObjectsLinkedToDR(String drName) throws JSchException, IOException {
		synergyObjects = this.synergyShell.getObjectsLinkedToDR(drName);
		this.deploymentRequest.setObjectList(synergyObjects);
	}

	public SynergyShell getShell() {
		return synergyShell;
	}

	public void setShell(SynergyShell shell) {
		this.synergyShell = shell;
	}

	public DeploymentRequest getDeploymentRequest() {
		return deploymentRequest;
	}

	public void setDeploymentRequest(DeploymentRequest deploymentRequest) {
		this.deploymentRequest = deploymentRequest;
	}

	public void setPatchList() throws JSchException, IOException {

		patchList = this.synergyShell.getPatchLinkedToDr(this.deploymentRequest.getDrName());
		this.deploymentRequest.setPatchList(patchList);

	}

	public void setDeploymentRequestInfo(DeploymentRequest deploymentRequest) throws JSchException, IOException {
		this.synergyShell.setDeploymentRequestInfo(deploymentRequest);

	}
}
