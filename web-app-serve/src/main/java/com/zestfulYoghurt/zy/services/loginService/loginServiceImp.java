package com.zestfulYoghurt.zy.services.loginService;
import com.zestfulYoghurt.zy.mappers.userMapper;
import com.zestfulYoghurt.zy.pojos.user;
import com.zestfulYoghurt.zy.tool.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * ClassName loginServiceImp
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Service("loginServiceImp")
public class loginServiceImp implements loginService{
    @Autowired
    Logger logger;

    @Resource
    private userMapper userMapper;

    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用户登录验证服务具体实现
     * @Date 11:25 2021/06/02
     * @Param [requestData]
     * @return java.util.Map
     **/
    @Override
    public Map loginCheckOut(Map requestData,Map responseData) {
        logger.info("登录");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(requestData.get("username").toString(),requestData.get("password").toString());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (Exception e){
            System.out.println("验证出现问题");
        }


        List<user> user = new ArrayList<>();
        try{
            user = userMapper.select(requestData);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("登录验证服务查询用户信息异常");
            responseData.put("message","登录异常");
        }
        if(user.size()==0){
            System.out.println("用户名不存在");
            responseData.put("message","用户名或密码错误");
            return responseData;
        }else{
            String password = user.get(0).getPassword();
            if(requestData.get("password").equals(password)){
                responseData.put("message","登录成功");
                //todo 需要添加一个登录的token
                return responseData;
            }else{
                System.out.println("密码错误");
                responseData.put("message","用户名或密码错误");
            }
        }
        return responseData;
    }

    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用户注册
     * @Date 17:16 2021/06/04
     * @Param [requestData, responseData]
     * @return java.util.Map
     **/
    @Override
    public Map register(Map requestData, Map responseData) {
        logger.debug(requestData.toString());
        //对用户密码进行加密
        Random random = new Random();
        int randomI = random.nextInt();
        String salt = randomI+(String)requestData.get("username");
        String password = Tools.encryption.passwordEncryption((String) requestData.get("password"), salt, 10);
        logger.debug("加密之后的密码:"+password);
        requestData.replace("password",password);
        requestData.put("salt",salt);
        try{
            userMapper.insert(requestData);
            responseData.put("message","注册成功");
        }catch(Exception e){
            responseData.put("message","注册失败");
            logger.debug("注册失败");
        }
        return responseData;
    }
}
