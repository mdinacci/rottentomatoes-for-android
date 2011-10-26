package com.marcodinacci.commons.data;

/**
 * Thrown when a problem is encountered during the unmarshalling process.
 */
public class UnmarshallerException extends RuntimeException {

	public UnmarshallerException(StackTraceElement[] stackTrace) {
		setStackTrace(stackTrace);
	}

	private static final long serialVersionUID = 233362559363957614L;

}
