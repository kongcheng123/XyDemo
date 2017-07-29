package com.example.demo.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by xy on 2017-07-29 23:59
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1");
        registrationBean.addInitParameter("deny", "192.168.31.234");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");
        registrationBean.addInitParameter("resetEnable", "false");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        return registrationBean;

    }

    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.username}") String userName,
                                      @Value("${spring.datasource.password}") String password,
                                      @Value("${spring.datasource.maxActive}") int maxActive,
                                      @Value("${spring.datasource.filters}") String filters,
                                      @Value("${spring.datasource.initialSize}")
                                              int initialSize,
                                      @Value("${spring.datasource.minIdle}")
                                              int minIdle,
                                      @Value("${spring.datasource.maxWait}")
                                              int maxWait,
                                      @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
                                              int timeBetweenEvictionRunsMillis,
                                      @Value("${spring.datasource.minEvictableIdleTimeMillis}")
                                              int minEvictableIdleTimeMillis,
                                      @Value("${spring.datasource.validationQuery}")
                                              String validationQuery,
                                      @Value("${spring.datasource.testWhileIdle}")
                                              boolean testWhileIdle,
                                      @Value("${spring.datasource.testOnBorrow}")
                                              boolean testOnBorrow,
                                      @Value("${spring.datasource.testOnReturn}")
                                              boolean testOnReturn,
                                      @Value("${spring.datasource.poolPreparedStatements}")
                                              boolean poolPreparedStatements,
                                      @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
                                              int maxPoolPreparedStatementPerConnectionSize,
                                      @Value("${spring.datasource.connectionProperties}")
                                              String connectionProperties,
                                      @Value("${spring.datasource.useGlobalDataSourceStat}")
                                              boolean useGlobalDataSourceStat

    ) throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
    /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

    /*数据源补充配置*/
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setFilters(filters);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        return dataSource;

    }
}
