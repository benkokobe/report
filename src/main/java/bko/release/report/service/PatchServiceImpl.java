package bko.release.report.service;

import java.util.List;

import org.springframework.stereotype.Component;

import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;
import bko.release.report.domain.TransferOperation;
import bko.release.report.persistence.PatchDao;

@Component
public class PatchServiceImpl implements PatchService{
	
	private PatchDao patchDao;

	public void setPatchDao(PatchDao patchDao) {
		this.patchDao = patchDao;
	}

	public List<PatchMember> getPatchMember(String REFPAT) {
		return patchDao.getPatchMembers(REFPAT);
	}

	public List<TransferOperation> getTransferOperation(String REFMAI) {
		return patchDao.getTransferOperation(REFMAI);
	}
	
	public List<Patch> getPatchDescription(String refpat) {
		return this.patchDao.getPatchDescription(refpat);
	}

}
