package com.cyb.spring.boot.openfeign.wechat.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyb.spring.boot.openfeign.wechat.service.WechatService;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;

/**
 * 微信配置
 * 
 * @author Administrator
 *
 */
@Configuration
public class WechatConfig {

	/**
	 * 初始化微信配置属性
	 * 
	 * @return
	 */
	@ConfigurationProperties("wechat")
	@Bean
	public WechatProperties wechatProperties() {
		return new WechatProperties();
	}

	/**
	 * 初始化解码程序
	 * 
	 * @param messageConverters 消息转换程序列表
	 * @return 解码程序
	 */
	@Bean
	public Decoder decoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		SpringDecoder springDecoder = new SpringDecoder(messageConverters);
		return new ResponseEntityDecoder(springDecoder);
	}

	/**
	 * 初始化编码程序
	 * 
	 * @param messageConverters 消息转换程序列表
	 * @return 编码程序
	 */
	@Bean
	public Encoder encoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		return new SpringEncoder(messageConverters);
	}

	@Bean
	public Client client() {
		return new Client.Default(null, null);
	}

	/**
	 * 初始化Feign契约
	 * 
	 * @return Feign契约
	 */
	@Bean
	public Contract contract() {
		return new SpringMvcContract();
	}

	/**
	 * 初始化微信服务
	 * 
	 * @param decoder          解码程序
	 * @param encoder          编码程序
	 * @param client           客户端
	 * @param contract         契约
	 * @param wechatProperties 微信配置属性
	 * @return 微信服务
	 */
	@Bean
	public WechatService wechatService(Decoder decoder, Encoder encoder, Client client, Contract contract,
			WechatProperties wechatProperties) {
		return Feign.builder().decoder(decoder).encoder(encoder).client(client).contract(contract)
				.target(WechatService.class, wechatProperties.getUrl());
	}
}
