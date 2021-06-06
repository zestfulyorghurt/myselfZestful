package com.zestfulYoghurt.zy.controllers.staffManagement;
import com.zestfulYoghurt.zy.services.staffManagementService.staffManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller("staffController")
public class staffManagementController {
    @Resource(name = "staffManagementServiceImp")
    private staffManagementService staffManagementServiceImp;

    /*
    * 删除一条员工信息
    * 5.20
    * */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/deleteStaffInfo")
    public Map deleteStaffInfo(@RequestBody String id){
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("线程睡眠出现问题");
        }
        Map responseData = new HashMap<>();
        String Message = "";
        Message = staffManagementServiceImp.deleteStaffInfo(id);
        responseData.put("Message",Message);
        return responseData;
    }
    
    /*
     * 根据员工id修改条员工信息
     * 5.21
     * */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updateStaffInfo")
    public Map updateStaffInfo(@RequestBody Map reqData){
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            System.out.println("线程睡眠出现问题");
        }
        Map responseData = new HashMap<>();
        String Message = "";
        Message = staffManagementServiceImp.updateStaffInfo(reqData);
        responseData.put("Message",Message);
        return responseData;
    }

    /*
    * 添加员工信息
    * 5.27
    * zestfulYoghurt
    * */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addStaffInfo")
    public Map addStaffInfo(@RequestBody Map reqData){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("线程睡眠出现问题");
        }
        Map responseData = new HashMap<>();
        String Message = staffManagementServiceImp.addStaffInfo(reqData);
        responseData.put("Message",Message);
        return responseData;
    }
}
