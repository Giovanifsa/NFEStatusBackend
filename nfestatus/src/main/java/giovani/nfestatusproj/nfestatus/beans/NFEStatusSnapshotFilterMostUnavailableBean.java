package giovani.nfestatusproj.nfestatus.beans;

import java.util.List;

import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public class NFEStatusSnapshotFilterMostUnavailableBean {
	private Integer page;
	private Integer rows;
	private List<EnumService> services;
	private Boolean treatUnknownStatusAsOffline;
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getRows() {
		return rows;
	}
	
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
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
