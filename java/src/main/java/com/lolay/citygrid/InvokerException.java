package com.lolay.citygrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvokerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private List<ErrorCode> errorCodes = null;
	public InvokerException(ErrorResults errors) {
		super("Errors occurred while invoking a request");
		List<ErrorCode> errorCodes = new ArrayList<ErrorCode>(errors.getErrors().size());
		for (Error error : errors.getErrors()) {
			errorCodes.add(error.getErrorCode());
		}
		this.errorCodes = Collections.unmodifiableList(errorCodes);
	}
	
	public List<ErrorCode> getErrorCodes() {
		return errorCodes;
	}

	public boolean contains(ErrorCode errorCode) {
		return getErrorCodes().contains(errorCode);
	}
}