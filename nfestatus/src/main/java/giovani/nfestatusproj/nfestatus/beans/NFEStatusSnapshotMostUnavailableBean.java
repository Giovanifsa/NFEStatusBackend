package giovani.nfestatusproj.nfestatus.beans;

import java.util.Date;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public class NFEStatusSnapshotMostUnavailableBean {
	private EnumAuthorizer authorizer;
	private EnumService service;
	private Long unavailableCount;
	private Date lastUnavailableMoment;
	
	public EnumAuthorizer getAuthorizer() {
		return authorizer;
	}
	
	public void setAuthorizer(EnumAuthorizer authorizer) {
		this.authorizer = authorizer;
	}
	
	public EnumService getService() {
		return service;
	}
	
	public void setService(EnumService service) {
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
}
