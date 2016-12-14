package com.waitme.spring.autoconfigure.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.util.ObjectUtils;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties({MybatisProperties.class})
@AutoConfigureAfter({ DataSourceAutoConfiguration.class })
public class MyBatisConfiguration implements TransactionManagementConfigurer {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MybatisProperties properties;
	
	
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
	    factory.setDataSource(dataSource);
	    if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
	      factory.setMapperLocations(this.properties.resolveMapperLocations());
	    }
	    return factory.getObject();
	}
	
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @ConditionalOnMissingBean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		 return new DataSourceTransactionManager(dataSource);
	}
    
    @Configuration
    @AutoConfigureAfter({ MyBatisConfiguration.class })
    public static class MapperScannerRegistrarConfiguration {
        @Bean
        public MapperScannerConfigurer mapperScannerConfigurer() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
            mapperScannerConfigurer.setBasePackage("com.waitme.mybatis.dao");
            return mapperScannerConfigurer;
        }
    }


}
