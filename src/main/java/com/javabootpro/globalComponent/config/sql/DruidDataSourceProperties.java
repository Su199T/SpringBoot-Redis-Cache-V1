package com.javabootpro.globalComponent.config.sql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源属性
 * @author Louis
 * @date Jan 12, 2019
 */

@Data
//把配置文件的自动映射到字段
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {

	// jdbc
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	// jdbc connection pool
	private int initialSize;
	private int minIdle;
	private int maxActive = 100;
	private long maxWait;
	private long timeBetweenEvictionRunsMillis;
	private long minEvictableIdleTimeMillis;
	private String validationQuery;
	private boolean testWhileIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private boolean poolPreparedStatements;
	private int maxPoolPreparedStatementPerConnectionSize;
	// filter
	private String filters;



}