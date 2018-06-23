package com.leon.framework.exception;

import com.leon.framework.enums.ErrorCode;

public class EggException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int code;
	private String errorMessage;

	public EggException(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.errorMessage = errorCode.getMessage();
	}

	public EggException(ErrorCode errorCode, Throwable ex) {
		super(ex);
		this.code = errorCode.getCode();
		this.errorMessage = errorCode.getMessage();
	}

	public EggException(int code, String msg) {
		this.code = code;
		this.errorMessage = msg;
	}

	public EggException(ErrorCode errorCode, String msg) {
		this.code = errorCode.getCode();
		this.errorMessage = msg;
	}

	public EggException(ErrorCode errorCode, String msg, Throwable ex) {
		super(ex);
		this.code = errorCode.getCode();
		this.errorMessage = msg;
	}

	public int getCode() {
		return this.code;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public String getMessage() {
		return this.errorMessage;
	}
}