package giovani.nfestatusproj.nfestatus.database.enums;

public enum EnumNFEStatus {
	ONLINE("Online"),
	FAILING("Failing"),
	OFFLINE("Offline"),
	UNKNOWN("Unknown"),
	;
	
	private final String statusDescription;
	
	private EnumNFEStatus(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getStatusDescription() {
		return statusDescription;
	}
}
