package com.futurenostics.dto;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminActionDetailDto {
	
	private String recordIdentifier;
	private List<String> caseRecordId;
	private String upicJurisdiction;
	private List<String> ptan;
	//@JsonSerializer(using =StandardDateSerializer)
	private ZonedDateTime creationDate;
	private String closeRationale;
	private String additionalInfo;
	private String status;
	//@JsonSerializer(using =StandardDateSerializer)
	private ZonedDateTime statusDate;
	private List<String> allowableAction;
	private String actionId;
	private String zprType;
	
	public AdminActionDetailDto(
			String recordIdentifier,
			String upicJurisdiction,
			ZonedDateTime creationDate,
			String closeRationale,
			String additionalInfo,
			String status,
			ZonedDateTime stausDate,
			String actionId,
			String zprType) {
		this.recordIdentifier = recordIdentifier;
		this.upicJurisdiction = upicJurisdiction;
		this.creationDate = creationDate;
		this.closeRationale = closeRationale;
		this.additionalInfo = additionalInfo;
		this.status = status;
		this.statusDate = stausDate;
		this.actionId = actionId;
		this.zprType = zprType;
		
	}
	
	public AdminActionDetailDto(
			String recordIdentifier,
			String upicJurisdiction,
			ZonedDateTime creationDate,
			String additionalInfo,
			String status,
			ZonedDateTime stausDate
			) {
		this.recordIdentifier = recordIdentifier;
		this.upicJurisdiction = upicJurisdiction;
		this.creationDate = creationDate;
		this.additionalInfo = additionalInfo;
		this.status = status;
		this.statusDate = stausDate;
		
	}
	
	public AdminActionDetailDto(
			String recordIdentifier,
			String upicJurisdiction,
			ZonedDateTime creationDate,
			String status,
			ZonedDateTime stausDate,
			String closeRationale
			) {
		this.recordIdentifier = recordIdentifier;
		this.upicJurisdiction = upicJurisdiction;
		this.creationDate = creationDate;
		this.status = status;
		this.statusDate = stausDate;
		this.closeRationale = closeRationale;
	}
	

}
