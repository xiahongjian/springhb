package tech.hongjian.springhb.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "tech.hongjian.springhb.controller", includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class) })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Charset utf8 = Charset.forName("UTF-8");
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setWriteAcceptCharset(false);
		stringConverter.setDefaultCharset(utf8);
		stringConverter.setSupportedMediaTypes(
				Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8, MediaType.TEXT_HTML));
		converters.add(stringConverter);

		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new FormHttpMessageConverter());

		// Jaxb2RootElementHttpMessageConverter xmlConverter = new
		// Jaxb2RootElementHttpMessageConverter();
		// xmlConverter.setDefaultCharset(utf8);
		// xmlConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_XML,
		// MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_ATOM_XML));
		// // 设置xml类型数据的converter，需要放在fastjson的json converter之前，因为它支持的类型是MediaType.ALL
		// converters.add(new Jaxb2RootElementHttpMessageConverter());
		//
		// // 使用fastjson作为json converter
		// converters.add(new FastJsonHttpMessageConverter());
	}

//	@Bean
//	public ViewResolver viewResolver() {
//		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//		resolver.setPrefix("/WEB-INF/views");
//		resolver.setSuffix(".ftl");
//		// resolver.setExposeContextBeansAsAttributes(true);
//		resolver.setCache(true);
//		resolver.setContentType("text/html;charset=UTF-8");
//		resolver.setRequestContextAttribute("request");
//		resolver.setOrder(0);
//		return resolver;
//	}
//
//	@Bean
//	public FreeMarkerConfigurer freemarkerConfig() {
//		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//		// 设置编码，否则中文乱码
////		configurer.setDefaultEncoding("UTF-8");
////		configurer.setTemplateLoaderPath("/WEB-INF/templates/freemarker/");
//		return configurer;
//	}
}
