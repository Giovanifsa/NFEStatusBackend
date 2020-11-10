package giovani.nfestatusproj.nfestatus.beans;

import java.util.List;

import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public class NFEStatusSnapshotFilterMostUnavailableBean extends NFEStatusSnapshotFilterCommonBean {
	private List<EnumService> services;
	private Boolean treatUnknownStatusAsOffline;
	
	public List<EnumService> getServices() {
		return services;
	}
	
	public void setServices(List<EnumService> services) {
		this.services = services;
	}

	public Boolean getTreatUnknownStatusAsOffline() {
		return treatUnknownStatusAsOffline;
	}

	public void setTreatUnknownStatusAsOffline(Boolean treatUnknownStatusAsOffline) {
		this.treatUnknownStatusAsOffline = treatUnknownStatusAsOffline;
	}
}
