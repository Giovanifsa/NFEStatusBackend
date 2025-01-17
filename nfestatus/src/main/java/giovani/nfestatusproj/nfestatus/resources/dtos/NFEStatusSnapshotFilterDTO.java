package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterBean;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.utils.ListUtils;

public class NFEStatusSnapshotFilterDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	private Integer rows;
	private Date captureMoment;
	private List<EnumAuthorizerDTO> authorizers;
	private Boolean distinctByAuthorizerLatest;
	
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
	
	public Date getCaptureMoment() {
		return captureMoment;
	}
	
	public void setCaptureMoment(Date captureMoment) {
		this.captureMoment = captureMoment;
	}
	
	public List<EnumAuthorizerDTO> getAuthorizers() {
		return authorizers;
	}

	public void setAuthorizers(List<EnumAuthorizerDTO> authorizers) {
		this.authorizers = authorizers;
	}
	
	public Boolean getDistinctByAuthorizerLatest() {
		return distinctByAuthorizerLatest;
	}

	public void setDistinctByAuthorizerLatest(Boolean distinctByAuthorizerLatest) {
		this.distinctByAuthorizerLatest = distinctByAuthorizerLatest;
	}

	public NFEStatusSnapshotFilterBean toBean() {
		NFEStatusSnapshotFilterBean bean = new NFEStatusSnapshotFilterBean();
		
		bean.setCaptureMoment(getCaptureMoment());
		bean.setPage(getPage());
		bean.setRows(getRows());
		bean.setDistinctByAuthorizerLatest(getDistinctByAuthorizerLatest());
		
		if (!ListUtils.isEmpty(getAuthorizers())) {
			List<EnumAuthorizer> converted = getAuthorizers().stream()
					.map((dto) -> EnumAuthorizer.values()[dto.getEnumAuthorizerOrdinal()])
					.collect(Collectors.toList());

			bean.setAuthorizers(converted);
		}
		
		return bean;
	}
}
