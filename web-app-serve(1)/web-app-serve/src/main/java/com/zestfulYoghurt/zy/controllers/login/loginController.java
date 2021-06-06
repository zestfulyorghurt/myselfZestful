package com.zestfulYoghurt.zy.controllers.login;

import com.zestfulYoghurt.zy.services.loginService.loginService;
import com.zestfulYoghurt.zy.tool.Tools;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName loginController
 * Description TODO 登录控制
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Controller("loginController")
public class loginController {

    @Autowired
    Logger logger;

    public Integer number;

    @Resource(name = "loginServiceImp")
    private loginService loginServiceImp;
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 对用户的登录信息进行验证
     * @Date 11:12 2021/06/02
     * @Param [requestData]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/loginCheckOut")
    @ResponseBody
    public Map loginCheckOut(@RequestBody Map requestData){
        System.out.println(requestData);
        Map responseData = new HashMap<>();
        responseData = loginServiceImp.loginCheckOut(requestData, responseData);
        return responseData;
    }


    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用户注册
     * @Date 17:14 2021/06/04
     * @Param [requestData]
     * @return java.util.Map
     **/
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map register(@RequestBody Map requestData){
        System.out.println(requestData);
        Map responseData = new HashMap<>();
        responseData = loginServiceImp.register(requestData, responseData);
        return responseData;
    }
    
    
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 测试多线程
     * @Date 16:14 2021/06/04
     * @Param 
     * @return 
     **/
    @RequestMapping(value = "/ThreadTest")
    @ResponseBody
    public String ThreadString(){
            String s = Tools.encryption.passwordEncryption("zhang", "zhang", 10);
        return s;
//        testpojo testpojo = new testpojo();
//        testpojo.setNumber(0);
//        Thread testThread = new Thread(new testThread(logger,testpojo));
//        Thread test = new Thread(new test(logger,testpojo));
//        testThread.start();
//        test.start();
    }
}
