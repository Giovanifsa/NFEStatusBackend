package giovani.nfestatusproj.nfestatus.resources.dtos;

import java.io.Serializable;

import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;

public class EnumAuthorizerDTO implements Serializable {
	private static final long serialVersionUID = -1058892395018191945L;
	
	private int enumAuthorizerOrdinal;
	
	private String authorizer;
	
	private String authorizerInitials;
	
	public int getEnumAuthorizerOrdinal() {
		return enumAuthorizerOrdinal;
	}
	
	public void setEnumAuthorizerOrdinal(int enumAuthorizerOrdinal) {
		this.enumAuthorizerOrdinal = enumAuthorizerOrdinal;
	}
	
	public String getAuthorizer() {
		return authorizer;
	}
	
	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}
	
	public String getAuthorizerInitials() {
		return authorizerInitials;
	}
	
	public void setAuthorizerInitials(String authorizerInitials) {
		this.authorizerInitials = authorizerInitials;
	}
	
	public static EnumAuthorizerDTO parse(EnumAuthorizer enumAuthorizer) {
		EnumAuthorizerDTO dto = new EnumAuthorizerDTO();
		
		dto.setAuthorizer(enumAuthorizer.getAuthorizer());
		dto.setAuthorizerInitials(enumAuthorizer.getAuthorizerInitials());
		dto.setEnumAuthorizerOrdinal(enumAuthorizer.ordinal());
		
		return dto;
	}
}
