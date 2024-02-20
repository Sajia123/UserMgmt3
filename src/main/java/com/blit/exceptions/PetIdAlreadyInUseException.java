package com.blit.exceptions;

//new Checked Exception
public class PetIdAlreadyInUseException extends Exception {/**
	 * 
	 */
	private static final long serialVersionUID = -6984320816226481768L;

// RuntimeException{ if unchecked 

	public PetIdAlreadyInUseException() {
		super();
	}

	public PetIdAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PetIdAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
	}

	public PetIdAlreadyInUseException(String message) {
		super(message);
	}

	public PetIdAlreadyInUseException(Throwable cause) {
		super(cause);
	}
	
}
