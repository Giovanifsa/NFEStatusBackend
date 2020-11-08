package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;
import java.util.Date;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotMostUnavailableBean;

public class NFEStatusSnapshotMostUnavailableDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EnumAuthorizerDTO authorizer;
	private EnumServiceDTO service;
	private Long unavailableCount;
	private Date lastUnavailableMoment;
	
	public EnumAuthorizerDTO getAuthorizer() {
		return authorizer;
	}
	
	public void setAuthorizer(EnumAuthorizerDTO authorizer) {
		this.authorizer = authorizer;
	}
	
	public EnumServiceDTO getService() {
		return service;
	}
	
	public void setService(EnumServiceDTO service) {
		this.service = service;
	}
	
	public Long getUnavailableCount() {
		return unavailableCount;
	}
	
	public void setUnavailableCount(Long unavailableCount) {
		this.unavailableCount = unavailableCount;
	}
	
	public Date getLastUnavailableMoment() {
		return lastUnavailableMoment;
	}
	
	public void setLastUnavailableMoment(Date lastUnavailableMoment) {
		this.lastUnavailableMoment = lastUnavailableMoment;
	}
	
	public static NFEStatusSnapshotMostUnavailableDTO parse(NFEStatusSnapshotMostUnavailableBean bean) {
		NFEStatusSnapshotMostUnavailableDTO dto = new NFEStatusSnapshotMostUnavailableDTO();
		
		dto.setAuthorizer(EnumAuthorizerDTO.parse(bean.getAuthorizer()));
		dto.setLastUnavailableMoment(bean.getLastUnavailableMoment());
		dto.setService(EnumServiceDTO.parse(bean.getService()));
		dto.setUnavailableCount(bean.getUnavailableCount());
		
		return dto;
	}
}
