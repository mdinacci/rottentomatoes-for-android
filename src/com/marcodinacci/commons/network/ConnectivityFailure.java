package com.marcodinacci.commons.network;

/**
 * RuntimeException to be thrown when the device isn't can't connect to internet.
 */
public class ConnectivityFailure extends RuntimeException {

	private static final long serialVersionUID = 4668928584548572761L;

	public ConnectivityFailure(String message) {
		super(message);
	}
}
