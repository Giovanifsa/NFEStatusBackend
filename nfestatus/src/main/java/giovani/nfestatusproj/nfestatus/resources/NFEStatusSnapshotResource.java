package giovani.nfestatusproj.nfestatus.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterMostUnavailableResultBean;
import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterResultBean;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterDTO;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterMostUnavailableDTO;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterMostUnavailableResultDTO;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterResultDTO;
import giovani.nfestatusproj.nfestatus.services.QueryNFEStatusSnapshotService;

@RestController
@CrossOrigin
@RequestMapping("/nfestatussnapshot")
public class NFEStatusSnapshotResource {
	@Autowired
	private QueryNFEStatusSnapshotService queryNFEStatusSnapshotService;
	
	@PostMapping("/querybyauthorizersanddatepaginated")
	public NFEStatusSnapshotFilterResultDTO queryByAuthorizersAndDatePaginated(@RequestBody NFEStatusSnapshotFilterDTO filter) {
		NFEStatusSnapshotFilterResultBean results = queryNFEStatusSnapshotService.queryByAuthorizersAndDatePaginated(filter.toBean());
		
		return NFEStatusSnapshotFilterResultDTO.parse(results);
	}
	
	@PostMapping("/querybymostunavailableservicespaginated")
	public NFEStatusSnapshotFilterMostUnavailableResultDTO queryByMostUnavailableServicesPaginated(
										@RequestBody NFEStatusSnapshotFilterMostUnavailableDTO filter) {
		
		NFEStatusSnapshotFilterMostUnavailableResultBean results = 
				queryNFEStatusSnapshotService.queryByMostUnavailableServicesPaginated(filter.toBean());
		
		return NFEStatusSnapshotFilterMostUnavailableResultDTO.parse(results);
	}
}
