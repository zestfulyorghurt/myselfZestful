package com.zestfulYoghurt.zy.pojos;

import org.springframework.stereotype.Component;

/**
 * ClassName testpojo
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/04 2021.6.4
 * Version 1.0
 **/
@Component
public class testpojo {
    public Integer number;
    public void setNumber(Integer number){
        this.number = number;
    }
    public Integer getNumber(){
        return this.number;
    }

}
