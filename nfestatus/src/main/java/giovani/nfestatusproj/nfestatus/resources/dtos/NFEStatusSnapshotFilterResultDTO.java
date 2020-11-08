package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterResultBean;

public class NFEStatusSnapshotFilterResultDTO implements Serializable {
	private static final long serialVersionUID = -8297308250139388017L;
	
	private List<NFEStatusSnapshotDTO> results;
	private Long totalRecords;
	
	public List<NFEStatusSnapshotDTO> getResults() {
		return results;
	}
	
	public void setResults(List<NFEStatusSnapshotDTO> results) {
		this.results = results;
	}
	
	public Long getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public static NFEStatusSnapshotFilterResultDTO parse(NFEStatusSnapshotFilterResultBean bean) {
		NFEStatusSnapshotFilterResultDTO dto = new NFEStatusSnapshotFilterResultDTO();
		
		List<NFEStatusSnapshotDTO> converted = bean.getResults()
												   .stream()
												   .map((entity) -> NFEStatusSnapshotDTO.parse(entity))
												   .collect(Collectors.toList());
		
		dto.setResults(converted);
		dto.setTotalRecords(bean.getTotalRecords());
		
		return dto;
	}
}
