package tech.hongjian.springhb.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
@PropertySource(value = "classpath:ds/ds-jdbc.properties", ignoreResourceNotFound = true)
public class HibernateConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateConfig.class);
	
	@Value("${jdbc.driver:com.mysql.jdbc.Driver}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username:root}")
	private String username;
	@Value("${jdbc.password:root}")
	private String password;
	
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("tech.hongjian.springhb.entity");
		Properties props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("ds/hibernate.properties"));
		} catch (IOException e) {
			LOGGER.warn("Failed to load the hibernate config file.", e);
		}
		factoryBean.setHibernateProperties(props);
		try {
			factoryBean.afterPropertiesSet();
		} catch (IOException e) {
			LOGGER.warn("Somthing wrong occuring duiring calling LocalSessionFactoryBean#afterPropertiesSet.", e);
		}
		return factoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory());
		return transactionManager;
	}
	
}
