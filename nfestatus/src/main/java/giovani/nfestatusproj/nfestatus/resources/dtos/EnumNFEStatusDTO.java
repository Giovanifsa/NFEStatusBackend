package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;

import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;

public class EnumNFEStatusDTO implements Serializable {
	private static final long serialVersionUID = 6524373132691826668L;
	
	private int enumNFEStatusOrdinal;
	
	private String statusDescription;
	
	public int getEnumNFEStatusOrdinal() {
		return enumNFEStatusOrdinal;
	}
	
	public void setEnumNFEStatusOrdinal(int enumNFEStatusOrdinal) {
		this.enumNFEStatusOrdinal = enumNFEStatusOrdinal;
	}
	
	public String getStatusDescription() {
		return statusDescription;
	}
	
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	public static EnumNFEStatusDTO parse(EnumNFEStatus status) {
		EnumNFEStatusDTO dto = new EnumNFEStatusDTO();
		
		dto.setEnumNFEStatusOrdinal(status.ordinal());
		dto.setStatusDescription(status.getStatusDescription());
		
		return dto;
	}
}
