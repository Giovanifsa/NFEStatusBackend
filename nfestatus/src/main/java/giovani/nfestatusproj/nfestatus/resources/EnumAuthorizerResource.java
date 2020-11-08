package giovani.nfestatusproj.nfestatus.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.resources.dtos.EnumAuthorizerDTO;

@RestController
@CrossOrigin
@RequestMapping("/authorizer")
public class EnumAuthorizerResource {

	@GetMapping("/listall")
	public List<EnumAuthorizerDTO> listAll() {
		return convertToDTOs(EnumAuthorizer.values());
	}
	
	private List<EnumAuthorizerDTO> convertToDTOs(EnumAuthorizer[] values) {
		List<EnumAuthorizerDTO> dtos = new ArrayList<>();
		
		for (EnumAuthorizer value : values) {
			dtos.add(EnumAuthorizerDTO.parse(value));
		}
		
		return dtos;
	}
}
