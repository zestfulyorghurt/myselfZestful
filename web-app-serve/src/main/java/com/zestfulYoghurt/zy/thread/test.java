package com.zestfulYoghurt.zy.thread;

import com.zestfulYoghurt.zy.pojos.testpojo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class test implements Runnable{
    Logger logger;
    testpojo pojo;
    public test(Logger logger, testpojo pojo){
        this.pojo = pojo;
        this.logger = logger;
    }
    public void run(){
        while (true){
            //logger.info("adad");
            Integer number = pojo.getNumber();
            pojo.setNumber(++number);
            logger.info(pojo.getNumber().toString());
        }
    }
}
