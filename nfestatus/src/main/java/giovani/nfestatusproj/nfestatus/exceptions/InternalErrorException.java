package giovani.nfestatusproj.nfestatus.exceptions;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends ApplicationException {
	private static final int HTTP_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();
	private static final long serialVersionUID = 65273782474812991L;
	
	public InternalErrorException(String message) {
		super(HTTP_CODE, message);
	}
	
	public InternalErrorException(Throwable th) {
		super(HTTP_CODE, th);
	}
}
