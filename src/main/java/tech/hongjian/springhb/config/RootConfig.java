package tech.hongjian.springhb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(HibernateConfig.class)
@ComponentScan(basePackages = "tech.hongjian.springhb", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
@EnableTransactionManagement 
public class RootConfig {

}
