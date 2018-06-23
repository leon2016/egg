package com.leon.framework.enums;

public enum ErrorCode {
	SUCCESS, DB_CONNECT_ERROR, DATA_SAVE_ERROR, DATA_QUERY_ERROR, DATA_BUSINESS_ERROR, LOGIN_ERROR, UNKNOWN_INTERNAL_ERROR, DB_ERROR, NULL_INPUT, NULL_OUTPUT, ILLEGAL_REQUEST, CHARACTER_ENCODE, CHARACTER_DENCODE, JSON_ERROR, IO_ERROR, REPEAT_RECORD_ERROR, OTHER_ERROR, HTTP_ERROR, USER_EXPIRED, PASSWORD_REPEAT, PASSWORD_FORMAT_WRONG, UID_ERROR, WID_ERROR, SETTING_ERROR, FILE_NOT_FOUND, FILE_TYPE_ERROR;

	private int code;
	private String message;

	public String toString() {
		return this.message;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}