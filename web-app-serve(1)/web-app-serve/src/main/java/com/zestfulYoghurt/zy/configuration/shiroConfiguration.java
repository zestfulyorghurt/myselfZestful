package com.zestfulYoghurt.zy.configuration;

import com.zestfulYoghurt.zy.shiro.loginRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * ClassName shiroConfiguration
 * Description TODO shiro框架配置
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Configuration
public class shiroConfiguration {
    @Bean("defaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    @Bean("myShiroRealm")
    public loginRealm myShiroRealm(){
        loginRealm loginRealm = new loginRealm();
        return loginRealm;
    }


    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        HashMap<String, String> map = new HashMap<>();
        //登出
        map.put("/logout","logout");
        //设置放行的url
        map.put("/register","anon");
        //对所有用户进行验证
        map.put("/**","authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/loginCheckOut");
        //首页
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误信息，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }



//    @Bean("Logger")
//    public Logger Logger(){
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        return logger;
//    }

}
