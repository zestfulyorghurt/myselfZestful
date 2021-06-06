package com.zestfulYoghurt.zy.services.loginService;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * InterfaceName loginService
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/02 2022.6.2
 * Version 1.0
 **/
@Component("loginService")
public interface loginService {
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用户登录验证方法
     * @Date 11:24 2021/06/02
     * @Param []
     * @return java.util.Map
     **/
    public Map loginCheckOut(Map requestData,Map responseData);

    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用户注册
     * @Date 17:15 2021/06/04
     * @Param [requestData, responseData]
     * @return java.util.Map
     **/
    public Map register(Map requestData,Map responseData);
}
