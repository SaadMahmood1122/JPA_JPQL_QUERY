package com.futurenostics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futurenostics.dto.AdminActionDetailDto;
import com.futurenostics.entities.AdminActions;

public interface AdminActionRepo extends JpaRepository<AdminActions, Integer>{
	
	@Query(
			"SELECT DISTINCT new com.futurenostics.dto.AdminActionDetailDto(a.ucmRecordId, a.originatingOrgCd as upicJurisdiction,"
			+ "a.actnDate as creationDate, a.caseCloseDesc as closeRationale, "
			+ "(case when a.typeRef.code='REV' then concat('REVOCATION LEGAL BASIS -', a.legalBasisDescrptns)"
			+ "when a.typeRef.code='OPT' then concat('FINANCE TYPE -', a.pspReason) "
			+ "when a.typeRef.code='RFI' then concat('CLOSING RATIONAL -', a.legalBasisDescrptns) end) as additioanlInfo"
			+ "a.status as status, "
			+ "(case when a.statusChangeDate != null then a.statusChangeDate else a.actinLastModifiedDate end) as statusDate,  "
			+ "a.ucmActnSk as actionId, a.zrType as zprType) "
			+ "FROM AdminAction a "
			+ "JOIN AdminProviderBrdg as b on a.ucmActnSk = b.ucmActnSk and a.deleteSwitch = b.deleteSwitch "
			+ "WHERE a.npi=:npi and a.typeRef NOT IN ('CSE', 'MPP', 'PDP', 'PPR')"
			)
	List<AdminActionDetailDto> findAdminActionByProviderNpi(@Param("npi") String npi);
	
//	Let suppose we have another entity the will retrun different AdminActionDto 
	//but write query for that in that repository
	

}
