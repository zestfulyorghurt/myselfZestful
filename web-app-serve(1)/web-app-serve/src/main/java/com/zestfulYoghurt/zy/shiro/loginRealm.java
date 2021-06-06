package com.zestfulYoghurt.zy.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName loginRealm
 * Description TODO shiro用户登录的realm
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Component
public class loginRealm extends AuthorizingRealm {
    @Autowired
    private Logger logger;

    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用于授权
     * @Date 12:18 2021/06/02
     * @Param [principals]
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权");
        return null;
    }
    
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用于验证
     * @Date 12:20 2021/06/02
     * @Param [token]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        System.out.println(token);
        System.out.println(token);
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        System.out.println(userToken.getHost());
        logger.info("456");
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("zestyoghurte","",getName());
        return simpleAuthenticationInfo;
    }
}
