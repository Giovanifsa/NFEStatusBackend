package giovani.nfestatusproj.nfestatus.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import giovani.nfestatusproj.nfestatus.database.enums.EnumService;
import giovani.nfestatusproj.nfestatus.resources.dtos.EnumServiceDTO;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class EnumServiceResource {

	@GetMapping("/listall")
	public List<EnumServiceDTO> listAll() {
		return convertToDTOs(EnumService.values());
	}
	
	private List<EnumServiceDTO> convertToDTOs(EnumService[] values) {
		List<EnumServiceDTO> dtos = new ArrayList<>();
		
		for (EnumService value : values) {
			dtos.add(EnumServiceDTO.parse(value));
		}
		
		return dtos;
	}
}