package giovani.nfestatusproj.nfestatus.database.enums;

public enum EnumService {
	AUTHORIZATION4("Autorização4", "nfeStatusAuthorization4"),
	AUTHORIZATION4RETURN("Retorno Autorização4", "nfeStatusAuthorization4Return"),
	INUTILISATION4("Inutilização4", "nfeStatusInutilisation4"),
	PROTOCOL4QUERY("Consulta Protocolo4", "nfeStatusProtocol4Query"),
	SERVICE4STATUS("Status Serviço4", "nfeStatusService4Status"),
	REGISTER4QUERY("Consulta Cadastro4", "nfeStatusRegister4Query"),
	EVENT4RECEPTION("Recepção Evento4", "nfeStatusEvent4Reception"),
	;
	
	private final String serviceDescription;
	private final String entityField;
	
	private EnumService(String serviceDescription, String entityField) {
		this.serviceDescription = serviceDescription;
		this.entityField = entityField;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public String getEntityField() {
		return entityField;
	}
}
