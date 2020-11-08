package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterMostUnavailableBean;
import giovani.nfestatusproj.nfestatus.database.enums.EnumService;
import giovani.nfestatusproj.nfestatus.utils.ListUtils;

public class NFEStatusSnapshotFilterMostUnavailableDTO implements Serializable {
	private static final long serialVersionUID = -7727907916022486531L;
	
	private Integer page;
	private Integer rows;
	private List<EnumServiceDTO> services;
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
	
	public List<EnumServiceDTO> getServices() {
		return services;
	}
	
	public void setServices(List<EnumServiceDTO> services) {
		this.services = services;
	}
	
	public Boolean getTreatUnknownStatusAsOffline() {
		return treatUnknownStatusAsOffline;
	}

	public void setTreatUnknownStatusAsOffline(Boolean treatUnknownStatusAsOffline) {
		this.treatUnknownStatusAsOffline = treatUnknownStatusAsOffline;
	}

	public NFEStatusSnapshotFilterMostUnavailableBean toBean() {
		NFEStatusSnapshotFilterMostUnavailableBean bean = new NFEStatusSnapshotFilterMostUnavailableBean();
		
		bean.setPage(getPage());
		bean.setRows(getRows());
		bean.setTreatUnknownStatusAsOffline(getTreatUnknownStatusAsOffline());
		
		if (!ListUtils.isEmpty(getServices())) {
			List<EnumService> converted = getServices().stream()
					.map((dto) -> EnumService.values()[dto.getEnumServiceOrdinal()])
					.collect(Collectors.toList());
			
			bean.setServices(converted);
		}
		
		return bean;
	}
}
