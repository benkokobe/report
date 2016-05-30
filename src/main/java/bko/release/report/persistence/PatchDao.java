package bko.release.report.persistence;

import java.util.List;

import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;
import bko.release.report.domain.TransferOperation;


public interface PatchDao {
	public Patch getPatch(String patchId);
	public List<TransferOperation> getTransferOperation(String patchId);
	public List<PatchMember> getPatchMembers(String patchId);
	public List<Patch> getPatchDescription(String NAMLOT);

}
