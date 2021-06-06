package com.zestfulYoghurt.zy.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * ClassName Tools
 * Description TODO 加密工具
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6.4
 * Version 1.0
 **/
public class Tools {
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 用于加密的内部类
     * @Date 17:10 2021/06/04
     * @Param 
     * @return 
     **/
    public static class encryption{
        public static String passwordEncryption(String password,String salt,Integer count){
            return new Md5Hash(password,salt,count).toString();
        }
    }

}
