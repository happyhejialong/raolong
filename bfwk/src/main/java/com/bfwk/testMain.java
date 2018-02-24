package com.bfwk;

import java.net.URLEncoder;

import org.apache.commons.codec.digest.DigestUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.bfwk.mapper")
public class testMain {
	public static void main(String[] args) {
	    String str = "{'OrderCode':'','ShipperCode':'ZTO','LogisticCode':'476337367445'}" + "16468a79-5802-4d8c-bc4c-140567e98c1c";
        str = URLEncoder.encode(new String(DigestUtils.md5(str)), "UTF-8");
        System.out.println(str);
	//	SpringApplication.run(testMain.class, args);
	}
	
	@Bean
	public HttpMessageConverters fastJsonConverters() {
		
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastConfig=new FastJsonConfig();
		
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastConfig);
	
		HttpMessageConverter<?> converter =  fastJsonHttpMessageConverter;
		return new HttpMessageConverters(converter);
	}
}
