package bko.release.report.persistence;

import java.util.List;

import bko.release.report.domain.DeploymentRequestTransferOperation;
import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;


public interface DeploymentRequestDao {
	public int getNumberOfPatches(String deploymentRequestName);
	public int getnumberOfTransferOperations(String deploymentRequestName);
	public int getNumberOfManualTransferOperations(String deploymentRequestName);
	public int getNumberOfSubjects(String deploymentRequestName);
	/* public List<Patch> getPatchList(String deploymentRequest);*/
	public List<Patch> getPatchList(String deploymentRequestName);
	/*public List<Patch> getPatchListComplete( String NAMLOT ); */
	public List<PatchMember> getDRMembers(String deploymentRequestName);
	public List<DeploymentRequestTransferOperation> getTransferOperation(String deploymentRequestName);
	public String getEnvDst(String deploymentRequestName);
	public String getEnvSrc(String deploymentRequestName);
	public String getSynopsis(String deploymentRequestName);
	
	public String getLastDrExecuted();
	public List<String> getLastNDrExecuted(int n);

}
