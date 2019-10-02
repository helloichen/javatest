package com.cy.ichendb.pj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @Configuration 注解描述的类为一个配置对象,此对象也会交给spring管理
 */
import org.springframework.context.annotation.Configuration;

@Configuration // bean
public class SpringShiroConfig {
	/**
	 * @Bean 描述的方法,其返回值会交给spring管理,一般应用再整合第三bean资源
	 * @return
	 */
	@Bean
	public SecurityManager newSecurityManager(@Autowired Realm realm) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}

	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		// 假如没有认证请求先访问此认证url
		sfBean.setLoginUrl("/doLoginUI");
		// 定义map指定请求过滤规则(哪些资源允许匿名访问,哪些资源必须认证访问)
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		// 静态资源允许匿名访问:"anon"
		map.put("/bower_components/**", "anon");
		map.put("/build/**", "anon");
		map.put("/dist/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/user/doLogin","anon");
		map.put("/doLogout","logout");
		// 除了匿名访问的资源,其他都要认证("authc")后访问
		map.put("/**", "authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}
}
