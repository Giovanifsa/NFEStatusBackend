package giovani.nfestatusproj.nfestatus.beans;

import java.util.Date;
import java.util.List;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

public class NFEStatusSnapshotFilterBean {
	private Integer page;
	private Integer rows;
	private Date captureMoment;
	private List<EnumAuthorizer> authorizers;
	private Boolean mostUnavailables;
	
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
	
	public List<EnumAuthorizer> getAuthorizers() {
		return authorizers;
	}

	public void setAuthorizers(List<EnumAuthorizer> authorizers) {
		this.authorizers = authorizers;
	}

	public Boolean getMostUnavailables() {
		return mostUnavailables;
	}
	
	public void setMostUnavailables(Boolean mostUnavailables) {
		this.mostUnavailables = mostUnavailables;
	}
}
