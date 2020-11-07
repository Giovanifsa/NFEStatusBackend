package giovani.nfestatusproj.nfestatus.exceptions;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 613929627331434776L;
	private final int statusCode;
	
	public ApplicationException(int statusCode, String errorMessage) {
		super(errorMessage);
		
		this.statusCode = statusCode;
	}
	
	public ApplicationException(int statusCode, Throwable th) {
		super(th);
		
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
