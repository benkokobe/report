package bko.release.report.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bko.release.report.domain.DeploymentRequestTransferOperation;
import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;
import bko.release.report.domain.TransferOperation;
import bko.release.report.persistence.DeploymentRequestDao;



@Component
public class DeploymentRequestServiceImpl implements DeploymentRequestService{
		
	private static final Logger LOGGER = LoggerFactory.getLogger(DeploymentRequestServiceImpl.class);
	
	@Autowired
	private DeploymentRequestDao deploymentRequestDao;

	public void setDeploymentRequestDao(DeploymentRequestDao deploymentRequestDao) {
		this.deploymentRequestDao = deploymentRequestDao;
	}

	public List<Patch> getPatchList(String deploymentRequest) {
		
		return this.deploymentRequestDao.getPatchList(deploymentRequest);
	}

	/*
	 * public List<Patch> getPatchListComplete(String NAMLOT) {
		return this.deploymentRequestDao.getPatchListComplete(NAMLOT);
	}
	*/

	public List<DeploymentRequestTransferOperation> getTransferOperation(String deploymentRequest) {
		return this.deploymentRequestDao.getTransferOperation(deploymentRequest);
	}


	public String getRefLot(String drName) {
		return getRefLot(drName);
	}

	public List<TransferOperation> getMissingYe(String reflot) {
		return getMissingYe(reflot);
	}

	@Override
	public List<PatchMember> getDRMembers(String drName) {
		return this.deploymentRequestDao.getDRMembers(drName);
	}

	@Override
	public int getNumberOfPatches(String deploymentRequestName) {
		return this.deploymentRequestDao.getNumberOfPatches(deploymentRequestName);
	}

	@Override
	public int getnumberOfTransferOperations(String deploymentRequestName) {
		return this.deploymentRequestDao.getnumberOfTransferOperations(deploymentRequestName);
	}

	@Override
	public int getNumberOfManualTransferOperations(String deploymentRequestName) {
		return this.deploymentRequestDao.getNumberOfManualTransferOperations(deploymentRequestName);
	}

	@Override
	public int getNumberOfSubjects(String deploymentRequestName) {
		return this.deploymentRequestDao.getNumberOfSubjects(deploymentRequestName);
	}

	@Override
	public String getEnvDst(String deploymentRequestName) {
		return this.deploymentRequestDao.getEnvDst(deploymentRequestName);
	}

	@Override
	public String getEnvSrc(String deploymentRequestName) {
		return this.deploymentRequestDao.getEnvSrc(deploymentRequestName);
	}

	@Override
	public String getSynopsis(String deploymentRequestName) {
		return this.deploymentRequestDao.getSynopsis(deploymentRequestName);
	}

}
