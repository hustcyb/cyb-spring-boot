package com.cyb.spring.boot.openfeign.wechat.dto;

import java.io.Serializable;

/**
 * 微信访问令牌
 * 
 * @author Administrator
 *
 */
public class WechatTokenDTO implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 访问令牌
	 */
	private String accessToken;

	/**
	 * 过期时间
	 */
	private Integer expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

}
