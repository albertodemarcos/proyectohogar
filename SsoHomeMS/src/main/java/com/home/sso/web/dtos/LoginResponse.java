package com.home.sso.web.dtos;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -876210957869712484L;
	private String code;
	private String messages;
	
	public LoginResponse() {
		super();
	}

	public LoginResponse(String code, String messages) {
		super();
		this.code = code;
		this.messages = messages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}
