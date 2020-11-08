package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.util.List;
import java.util.stream.Collectors;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterMostUnavailableResultBean;
import giovani.nfestatusproj.nfestatus.utils.ListUtils;

public class NFEStatusSnapshotFilterMostUnavailableResultDTO {
	private List<NFEStatusSnapshotMostUnavailableDTO> results;
	private Long totalRecords;
	
	public List<NFEStatusSnapshotMostUnavailableDTO> getResults() {
		return results;
	}

	public void setResults(List<NFEStatusSnapshotMostUnavailableDTO> results) {
		this.results = results;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public static NFEStatusSnapshotFilterMostUnavailableResultDTO parse(NFEStatusSnapshotFilterMostUnavailableResultBean bean) {
		NFEStatusSnapshotFilterMostUnavailableResultDTO dto = new NFEStatusSnapshotFilterMostUnavailableResultDTO();
		
		if (!ListUtils.isEmpty(bean.getResults())) {
			List<NFEStatusSnapshotMostUnavailableDTO> converted = bean.getResults().stream()
					.map((beanToDTO) -> NFEStatusSnapshotMostUnavailableDTO.parse(beanToDTO))
					.collect(Collectors.toList());
			
			dto.setResults(converted);
		}
		
		dto.setTotalRecords(bean.getTotalRecords());
		
		return dto;
	}
}
