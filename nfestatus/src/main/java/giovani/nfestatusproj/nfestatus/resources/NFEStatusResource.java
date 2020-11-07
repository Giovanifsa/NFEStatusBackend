package giovani.nfestatusproj.nfestatus.resources;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import giovani.nfestatusproj.nfestatus.database.eao.NFEStatusSnapshotEAO;
import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

@RestController
public class NFEStatusResource {
	@Autowired
	private NFEStatusSnapshotEAO nfeStatusSnapshotEAO;
	
	@GetMapping("/nfestatus/findbyauthorizer/{authorizer}")
	public List<NFEStatusSnapshot> findByAuthorizer(@PathVariable("authorizer") String authorizerEncoded) {
		String authorizerDecoded = URLDecoder.decode(authorizerEncoded, StandardCharsets.UTF_8);
		EnumAuthorizer authorizer = EnumAuthorizer.parseInitials(authorizerDecoded);
		
		return nfeStatusSnapshotEAO.findByAuthorizer(authorizer);
	}
}
