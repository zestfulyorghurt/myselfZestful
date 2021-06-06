package com.zestfulYoghurt.zy.pojos;

import org.springframework.stereotype.Component;

/**
 * ClassName user
 * Description TODO 用户登陆者实体类
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Component
public class user {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String role;

    public user(){

    }
    public user(Integer id,String name,String password,String salt,String role){
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
