package com.zestfulYoghurt.zy.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName loggerConfiguration
 * Description TODO 对日志进行配置
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6.4
 * Version 1.0
 **/
@Configuration
public class loggerConfiguration {
    private static Logger logger;
    @Bean("Logger")
    public static synchronized Logger Logger(){
        if(logger==null){
            logger = LoggerFactory.getLogger(loggerConfiguration.class);
        }
        return logger;
    }

}
