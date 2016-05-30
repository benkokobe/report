package bko.release.report.service;

import java.util.List;

import bko.release.report.domain.Patch;
import bko.release.report.domain.PatchMember;
import bko.release.report.domain.TransferOperation;


public interface PatchService {
	List<PatchMember> getPatchMember( String refpat );
	List<TransferOperation> getTransferOperation(String refpat);
	List<Patch> getPatchDescription(String refpat);
}
