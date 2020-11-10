package giovani.nfestatusproj.nfestatus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends ApplicationException {
	private static final long serialVersionUID = -5573443298637375939L;

	public InternalErrorException() {
		super();
	}

	public InternalErrorException(String message, 
								  Throwable cause, 
								  boolean enableSuppression,
								  boolean writableStackTrace) {
		
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InternalErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalErrorException(String message) {
		super(message);
	}

	public InternalErrorException(Throwable cause) {
		super(cause);
	}
}
