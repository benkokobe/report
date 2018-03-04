package bko.release.report.service;

import java.util.List;

import bko.release.report.domain.DeploymentRequestTransferOperation;
import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;
import bko.release.report.domain.TransferOperation;


public interface DeploymentRequestService {
	public int getNumberOfPatches(String deploymentRequestName);
	public int getnumberOfTransferOperations(String deploymentRequestName);
	public int getNumberOfManualTransferOperations(String deploymentRequestName);
	public int getNumberOfSubjects(String deploymentRequestName);
	public List<Patch> getPatchList(String deploymentRequest);
	//public List<Patch> getPatchListComplete( String NAMLOT );
	public List<PatchMember> getDRMembers(String drName);
	public List<DeploymentRequestTransferOperation> getTransferOperation(String deploymentRequest);
	public String getRefLot(String drName);
	public List<TransferOperation> getMissingYe(String reflot);
	public String getEnvDst(String deploymentRequestName);
	public String getEnvSrc(String deploymentRequestName);
	public String getSynopsis(String deploymentRequestName);
	
	public String getLastDrExecuted();
	public List<String> getLastNDrExecuted(int n);

}
