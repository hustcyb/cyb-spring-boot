package com.cyb.spring.boot.openfeign.wechat.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyb.spring.boot.openfeign.wechat.dto.WechatTokenDTO;
import com.cyb.spring.boot.openfeign.wechat.dto.WechatResponseDTO;

/**
 * 微信服务
 * 
 * @author Administrator
 *
 */
public interface WechatService {

	@GetMapping("token")
	WechatResponseDTO<WechatTokenDTO> getToken(@RequestParam("grant_type") String grantType,
			@RequestParam("appid") String appId, @RequestParam("secret") String secret);
}
