package com.zestfulYoghurt.zy.thread;

import com.zestfulYoghurt.zy.pojos.testpojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName testThread
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6
 * Version 1.0
 **/
@Component
public class testThread implements Runnable{
    Logger logger;
    testpojo pojo;
    public testThread(Logger logger, testpojo pojo){
        this.pojo = pojo;
        this.logger = logger;
    }
    public void run(){
        while (true){
//            logger.info("adad");
            Integer number = pojo.getNumber();
            pojo.setNumber(++number);
            logger.info(pojo.getNumber().toString());
        }
       // System.out.println("78569");
    }
}
