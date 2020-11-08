package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;

import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public class EnumServiceDTO implements Serializable {
	private static final long serialVersionUID = -1266888279040505283L;
	
	private int enumServiceOrdinal;
	private String serviceDescription;
	
	public int getEnumServiceOrdinal() {
		return enumServiceOrdinal;
	}
	
	public void setEnumServiceOrdinal(int enumServiceOrdinal) {
		this.enumServiceOrdinal = enumServiceOrdinal;
	}
	
	public String getServiceDescription() {
		return serviceDescription;
	}
	
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	public static EnumServiceDTO parse(EnumService enumService) {
		EnumServiceDTO dto = new EnumServiceDTO();
		
		dto.setEnumServiceOrdinal(enumService.ordinal());
		dto.setServiceDescription(enumService.getServiceDescription());
		
		return dto;
	}
}
