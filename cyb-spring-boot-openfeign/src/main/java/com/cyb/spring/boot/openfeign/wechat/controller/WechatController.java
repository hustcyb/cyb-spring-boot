package com.cyb.spring.boot.openfeign.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.boot.openfeign.wechat.config.WechatProperties;
import com.cyb.spring.boot.openfeign.wechat.dto.WechatResponseDTO;
import com.cyb.spring.boot.openfeign.wechat.dto.WechatTokenDTO;
import com.cyb.spring.boot.openfeign.wechat.service.WechatService;

/**
 * 微信示例控制器
 * 
 * @author Administrator
 *
 */
@RestController
public class WechatController {

	/**
	 * 获取访问令牌的授权类型
	 */
	private static final String clientCredential = "client_credential";

	/**
	 * 微信配置属性
	 */
	@Autowired
	private WechatProperties wechatProperties;

	/**
	 * 微信服务
	 */
	@Autowired
	private WechatService wechatService;

	@GetMapping("token")
	public WechatResponseDTO<WechatTokenDTO> getToken() {
		return wechatService.getToken(clientCredential, wechatProperties.getAppId(), wechatProperties.getSecret());
	}
}
