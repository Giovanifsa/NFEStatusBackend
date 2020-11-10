package giovani.nfestatusproj.nfestatus.beans;

import java.util.Date;
import java.util.List;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

public class NFEStatusSnapshotFilterBean  extends NFEStatusSnapshotFilterCommonBean {
	private Date captureMoment;
	private List<EnumAuthorizer> authorizers;
	private Boolean distinctByAuthorizerLatest;
	
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

	public Boolean getDistinctByAuthorizerLatest() {
		return distinctByAuthorizerLatest;
	}

	public void setDistinctByAuthorizerLatest(Boolean distinctByAuthorizerLatest) {
		this.distinctByAuthorizerLatest = distinctByAuthorizerLatest;
	}
}
