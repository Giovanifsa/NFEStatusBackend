package giovani.nfestatusproj.nfestatus.database.enums;

public enum EnumAuthorizer {
	AM("Amazonas", "AM"),
	BA("Bahia", "BA"),
	CE("Ceará", "CE"),
	GO("Goiás", "GO"),
	MT("Mato Grosso", "MT"),
	MS("Mato Grosso do Sul", "MS"),
	MG("Minas Gerais", "MG"),
	PR("Paraná", "PR"),
	PE("Pernambuco", "PE"),
	RJ("Rio de Janeiro", "RJ"),
	RS("Rio Grande do Sul", "RS"),
	SP("São Paulo", "SP"),
	SVAN("SVAN", "SVAN"),
	SVRS("SVRS", "SVRS"),
	SVC_AN("SVC-AN", "SVC-AN"),
	SVC_RS("SVC-RS", "SVC-RS"),
	UNKNOWN("UNKNOWN", "UNKNOWN"),
	;
	
	private String authorizer;
	private String authorizerInitials;
	
	private EnumAuthorizer(String authorizer, String authorizerInitials) {
		this.authorizer = authorizer;
		this.authorizerInitials = authorizerInitials;
	}

	public String getAuthorizer() {
		return authorizer;
	}

	public String getAuthorizerInitials() {
		return authorizerInitials;
	}
	
	public static EnumAuthorizer parseInitials(String value) {
		for (EnumAuthorizer _enum : values()) {
			if (_enum.getAuthorizerInitials().equals(value)) {
				return _enum;
			}
		}
		
		return UNKNOWN;
	}
}
