package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;
import java.util.Date;

import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;

public class NFEStatusSnapshotDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idNFEStatusSnapshot;
	
	private Date captureMoment;
	
	private EnumAuthorizerDTO authorizer;
	
	private EnumNFEStatusDTO nfeStatusAuthorization4;
	
	private EnumNFEStatusDTO nfeStatusAuthorization4Return;
	
	private EnumNFEStatusDTO nfeStatusInutilisation4;
	
	private EnumNFEStatusDTO nfeStatusProtocol4Query;
	
	private EnumNFEStatusDTO nfeStatusService4Status;
	
	private Long averageTimeMilis;
	
	private EnumNFEStatusDTO nfeStatusRegister4Query;
	
	private EnumNFEStatusDTO nfeStatusEvent4Reception;
	
	public Long getIdNFEStatusSnapshot() {
		return idNFEStatusSnapshot;
	}

	public void setIdNFEStatusSnapshot(Long idNFEStatusSnapshot) {
		this.idNFEStatusSnapshot = idNFEStatusSnapshot;
	}

	public Date getCaptureMoment() {
		return captureMoment;
	}

	public void setCaptureMoment(Date captureMoment) {
		this.captureMoment = captureMoment;
	}

	public EnumAuthorizerDTO getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(EnumAuthorizerDTO authorizer) {
		this.authorizer = authorizer;
	}

	public EnumNFEStatusDTO getNfeStatusAuthorization4() {
		return nfeStatusAuthorization4;
	}

	public void setNfeStatusAuthorization4(EnumNFEStatusDTO nfeStatusAuthorization4) {
		this.nfeStatusAuthorization4 = nfeStatusAuthorization4;
	}

	public EnumNFEStatusDTO getNfeStatusAuthorization4Return() {
		return nfeStatusAuthorization4Return;
	}

	public void setNfeStatusAuthorization4Return(EnumNFEStatusDTO nfeStatusAuthorization4Return) {
		this.nfeStatusAuthorization4Return = nfeStatusAuthorization4Return;
	}

	public EnumNFEStatusDTO getNfeStatusInutilisation4() {
		return nfeStatusInutilisation4;
	}

	public void setNfeStatusInutilisation4(EnumNFEStatusDTO nfeStatusInutilisation4) {
		this.nfeStatusInutilisation4 = nfeStatusInutilisation4;
	}

	public EnumNFEStatusDTO getNfeStatusProtocol4Query() {
		return nfeStatusProtocol4Query;
	}

	public void setNfeStatusProtocol4Query(EnumNFEStatusDTO nfeStatusProtocol4Query) {
		this.nfeStatusProtocol4Query = nfeStatusProtocol4Query;
	}

	public EnumNFEStatusDTO getNfeStatusService4Status() {
		return nfeStatusService4Status;
	}

	public void setNfeStatusService4Status(EnumNFEStatusDTO nfeStatusService4Status) {
		this.nfeStatusService4Status = nfeStatusService4Status;
	}

	public Long getAverageTimeMilis() {
		return averageTimeMilis;
	}

	public void setAverageTimeMilis(Long averageTimeMilis) {
		this.averageTimeMilis = averageTimeMilis;
	}

	public EnumNFEStatusDTO getNfeStatusRegister4Query() {
		return nfeStatusRegister4Query;
	}

	public void setNfeStatusRegister4Query(EnumNFEStatusDTO nfeStatusRegister4Query) {
		this.nfeStatusRegister4Query = nfeStatusRegister4Query;
	}

	public EnumNFEStatusDTO getNfeStatusEvent4Reception() {
		return nfeStatusEvent4Reception;
	}

	public void setNfeStatusEvent4Reception(EnumNFEStatusDTO nfeStatusEvent4Reception) {
		this.nfeStatusEvent4Reception = nfeStatusEvent4Reception;
	}
	
	public static NFEStatusSnapshotDTO parse(NFEStatusSnapshot entity) {
		NFEStatusSnapshotDTO dto = new NFEStatusSnapshotDTO();
		
		dto.setAuthorizer(EnumAuthorizerDTO.parse(entity.getAuthorizer()));
		dto.setAverageTimeMilis(entity.getAverageTimeMilis());
		dto.setCaptureMoment(entity.getCaptureMoment());
		dto.setIdNFEStatusSnapshot(entity.getIdNFEStatusSnapshot());
		dto.setNfeStatusAuthorization4(EnumNFEStatusDTO.parse(entity.getNfeStatusAuthorization4()));
		dto.setNfeStatusAuthorization4Return(EnumNFEStatusDTO.parse(entity.getNfeStatusAuthorization4Return()));
		dto.setNfeStatusEvent4Reception(EnumNFEStatusDTO.parse(entity.getNfeStatusEvent4Reception()));
		dto.setNfeStatusInutilisation4(EnumNFEStatusDTO.parse(entity.getNfeStatusInutilisation4()));
		dto.setNfeStatusProtocol4Query(EnumNFEStatusDTO.parse(entity.getNfeStatusProtocol4Query()));
		dto.setNfeStatusRegister4Query(EnumNFEStatusDTO.parse(entity.getNfeStatusRegister4Query()));
		dto.setNfeStatusService4Status(EnumNFEStatusDTO.parse(entity.getNfeStatusService4Status()));
		
		return dto;
	}
}
