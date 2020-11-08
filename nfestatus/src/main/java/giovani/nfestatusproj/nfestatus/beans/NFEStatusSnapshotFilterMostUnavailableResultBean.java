package giovani.nfestatusproj.nfestatus.beans;

import java.util.Collections;
import java.util.List;

public class NFEStatusSnapshotFilterMostUnavailableResultBean {
	private List<NFEStatusSnapshotMostUnavailableBean> results;
	private Long totalRecords;
	
	public List<NFEStatusSnapshotMostUnavailableBean> getResults() {
		return results;
	}

	public void setResults(List<NFEStatusSnapshotMostUnavailableBean> results) {
		this.results = results;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public static NFEStatusSnapshotFilterMostUnavailableResultBean empty() {
		NFEStatusSnapshotFilterMostUnavailableResultBean bean = new NFEStatusSnapshotFilterMostUnavailableResultBean();
		
		bean.setResults(Collections.emptyList());
		bean.setTotalRecords(0L);
		
		return bean;
	}
}
