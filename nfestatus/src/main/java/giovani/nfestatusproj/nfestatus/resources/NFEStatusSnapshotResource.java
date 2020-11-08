package giovani.nfestatusproj.nfestatus.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import giovani.nfestatusproj.nfestatus.beans.NFEStatusSnapshotFilterResultBean;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterDTO;
import giovani.nfestatusproj.nfestatus.resources.dtos.NFEStatusSnapshotFilterResultDTO;
import giovani.nfestatusproj.nfestatus.services.NFEStatusSnapshotService;

@RestController
@CrossOrigin
@RequestMapping("/nfestatussnapshot")
public class NFEStatusSnapshotResource {
	@Autowired
	private NFEStatusSnapshotService nfeStatusSnapshotService;
	
	@PostMapping("/paginated")
	public NFEStatusSnapshotFilterResultDTO findPaginated(@RequestBody NFEStatusSnapshotFilterDTO filter) {
		NFEStatusSnapshotFilterResultBean results = nfeStatusSnapshotService.querySnapshotsPaginated(filter.toBean());
		
		return NFEStatusSnapshotFilterResultDTO.parse(results);
	}
}
