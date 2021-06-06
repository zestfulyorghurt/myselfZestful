package com.zestfulYoghurt.zy.controllers.staffManagement;

import com.zestfulYoghurt.zy.services.staffManagementService.staffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("getResources")
public class getResources {
    @Resource(name = "staffManagementServiceImp")
    private staffManagementService staffManagementServiceImp;
    /*
    * 返回员工信息
    * 分页
    * zestfulYoghurt 2021.5.19
    * */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getResourceStaff")
    public Map getResourceStaff(@RequestBody Map requestData){
        /*
        * 页面需要的数据主要有两个
        * 员工信息
        * 分页显示信息
        * */
        ThreadSleep(1000);
        //定义员工信息集合
        List staffInfo = new ArrayList<>();
        //定义分页的具体页数
        List pagingInfo = new ArrayList<>();
        Map responseData = new HashMap<>();
        //调用服务
        responseData = staffManagementServiceImp.getResources(staffInfo, pagingInfo, requestData, responseData);
        return responseData;
    }
    /*
     *按照条件进行查询
     *  返回员工信息
     * 分页
     * zestfulYoghurt 2021.5.19
     * */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getResourceStaffCondition")
    public Map getResourceStaffCondition(@RequestBody Map requestData){
        /*
         * 页面需要的数据主要有两个
         * 员工信息
         * 分页显示信息
         * */
        ThreadSleep(1000);
        //定义员工信息集合
        List staffInfo = new ArrayList<>();
        //定义分页的具体页数
        List pagingInfo = new ArrayList<>();
        Map responseData = new HashMap<>();
        //调用服务
        responseData = staffManagementServiceImp.getResourcesByCondition(staffInfo, pagingInfo, requestData, responseData);
        return responseData;
    }




    public void ThreadSleep(Integer second){
        try{
            Thread.sleep(second);
        }catch(Exception e){
            System.out.println("线程睡眠出现问题");
        }
    }
}
