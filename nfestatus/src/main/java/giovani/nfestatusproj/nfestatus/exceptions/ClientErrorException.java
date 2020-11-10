package giovani.nfestatusproj.nfestatus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ClientErrorException extends ApplicationException {
	private static final long serialVersionUID = -6867691997066769398L;

	public ClientErrorException() {
		super();
	}

	public ClientErrorException(String message, 
								Throwable cause, 
								boolean enableSuppression,
								boolean writableStackTrace) {
		
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClientErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientErrorException(String message) {
		super(message);
	}

	public ClientErrorException(Throwable cause) {
		super(cause);
	}
}
