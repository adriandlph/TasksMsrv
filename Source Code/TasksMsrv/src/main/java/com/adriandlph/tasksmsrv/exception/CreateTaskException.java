
package com.adriandlph.tasksmsrv.exception;

import com.adriandlph.msrv.exception.MsrvException;

/**
 *
 * @author adriandlph
 *
 */
public class CreateTaskException extends MsrvException {

	public CreateTaskException() {
	}

	public CreateTaskException(String message) {
		super(message);
	}

	public CreateTaskException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateTaskException(Throwable cause) {
		super(cause);
	}

	public CreateTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreateTaskException(int code) {
		super(code);
	}

	public CreateTaskException(int code, String message) {
		super(code, message);
	}

	public CreateTaskException(int code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public CreateTaskException(int code, Throwable cause) {
		super(code, cause);
	}

	public CreateTaskException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(code, message, cause, enableSuppression, writableStackTrace);
	}

}
