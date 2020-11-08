package giovani.nfestatusproj.nfestatus.beans;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;

public class NFEStatusSnapshotFilterResultBean {
	private List<NFEStatusSnapshot> results;
	private Long totalRecords;
	
	public List<NFEStatusSnapshot> getResults() {
		return results;
	}
	
	public void setResults(List<NFEStatusSnapshot> results) {
		this.results = results;
	}
	
	public Long getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public static NFEStatusSnapshotFilterResultBean ofPage(Page<NFEStatusSnapshot> page) {
		NFEStatusSnapshotFilterResultBean bean = new NFEStatusSnapshotFilterResultBean();
		
		bean.setResults(page.getContent());
		bean.setTotalRecords(page.getTotalElements());
		
		return bean;
	}
	
	public static NFEStatusSnapshotFilterResultBean empty() {
		NFEStatusSnapshotFilterResultBean bean = new NFEStatusSnapshotFilterResultBean();
		
		bean.setResults(Collections.emptyList());
		bean.setTotalRecords(0L);
		
		return bean;
	}
}
