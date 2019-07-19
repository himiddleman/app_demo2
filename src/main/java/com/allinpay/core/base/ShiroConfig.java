//package com.allinpay.core.base;
//
//import org.apache.shiro.mgt.RememberMeManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//
//    @Bean
//    public DefaultWebSessionManager sessionManager(@Value("${globalSessionTimeout:3600}") long globalSessionTimeout) {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionValidationSchedulerEnabled(false);
//        sessionManager.setSessionIdUrlRewritingEnabled(false);
//        sessionManager.setSessionValidationInterval(globalSessionTimeout * 1000L);
//        sessionManager.setGlobalSessionTimeout(globalSessionTimeout * 1000L);
//        return sessionManager;
//    }
//
//    @Bean("securityManager")
//    public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(userRealm);
//        securityManager.setSessionManager(sessionManager);
//        securityManager.setRememberMeManager((RememberMeManager) null);
//        return securityManager;
//    }
//
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//        shiroFilter.setLoginUrl("/web/login");
//        Map<String, String> filterMap = new LinkedHashMap();
//        filterMap.put("/templates/**", "anon");
//        filterMap.put("/static/**", "anon");
//        filterMap.put("/favicon.ico", "anon");
//        filterMap.put("/web/login", "anon");
//        filterMap.put("/logout", "anon");
//        filterMap.put("/etc/captcha", "anon");
//        filterMap.put("/etc/login", "anon");
//        filterMap.put("/login.html", "anon");
//        filterMap.put("/static/js/**", "anon");
//        filterMap.put("/etcimg/**", "anon");
//        filterMap.put("/**", "authc");
//        shiroFilter.setSuccessUrl("/index");
//        shiroFilter.setUnauthorizedUrl("/web/403");
//        shiroFilter.setFilterChainDefinitionMap(filterMap);
//        return shiroFilter;
//    }
//
//    @Bean("lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    //开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
//    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//}
