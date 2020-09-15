package com.cyb.spring.boot.openfeign.wechat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 微信响应结果
 * 
 * @author Administrator
 *
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class WechatResponseDTO<T> implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	private int errCode;

	private String errMsg;

	@JsonUnwrapped
	private T data;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
