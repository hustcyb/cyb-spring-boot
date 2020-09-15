package com.cyb.spring.boot.openfeign.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信配置属性
 * @author Administrator
 *
 */
@ConfigurationProperties("wechat")
public class WechatProperties {

	/**
	 * 微信接口地址
	 */
	private String url;
	
	/**
	 * 应用标识
	 */
	private String appId;
	
	/**
	 * 密钥
	 */
	private String secret;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
