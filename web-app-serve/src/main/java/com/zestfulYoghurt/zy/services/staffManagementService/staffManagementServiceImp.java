package com.zestfulYoghurt.zy.services.staffManagementService;

import com.zestfulYoghurt.zy.mappers.staffMapper;
import com.zestfulYoghurt.zy.pojos.staff;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("staffManagementServiceImp")
public class staffManagementServiceImp implements staffManagementService {
    @Resource
    private  staffMapper staffMapper;
    @Override
    public List<staff> getAllStaffByCondition(Map reqData) {
        return staffMapper.getAllStaffByCondition(reqData);
    }
    /*
    * 查询指定的页的数据
    * 分页查询
    * staffInfo:员工信息
    * paging:分页具体页数
    * requestData:当前页数和查询数据条数
    * 5.20
    * */
    @Override
    public Map getResources(List staffInfo, List paging,Map requestData,Map responseData) {
        /*
        * 定义分页公式
        */
        //定义当前页
        Integer currentPage = (Integer) requestData.get("current_page");
        //定义最大检索条数
        Integer dataNumber = (Integer) requestData.get("data_number");
        //定义分页查询sql所需参数
        Map pag = new HashMap();
        //查询开始索引
        pag.put("startIndex",(currentPage-1)*dataNumber);
        //查询数据条数
        pag.put("dataNumber",(dataNumber));
        //按照分页查询员工信息
        staffInfo = staffMapper.getStaffInfoPaging(pag);
        //添加具体分页信息
        List<staff> allStaffInfo = staffMapper.getAllStaffInfo();
        Integer pagingData = allStaffInfo.size()/10;
        for(int i = 0;i<(pagingData+1);i++){
            paging.add(i+1);
        }
        //封装数据
        responseData.put("staffInfo",staffInfo);
        responseData.put("paging",paging);
        return responseData;
    }

    /*
     *根据条件查询页面信息
     *  staffInfo:员工信息
     * paging:分页具体页数
     * requestData:当前页数和查询数据条数和查询条件
     * 5.20
     * */
    @Override
    public Map getResourcesByCondition(List staffInfo, List paging, Map requestData, Map responseData) {
        /*
         * 定义分页公式
         */
        //定义当前页
        Integer currentPageCondition= (Integer) requestData.get("current_page");
        //定义最大检索条数
        Integer dataNumber = (Integer) requestData.get("data_number");
        //定义分页查询sql所需参数
        Map pag = new HashMap();
        String age = (String)requestData.get("age");
        String[] splitAge = age.split("-");
        Map ageCondition = new HashMap<>();
        ageCondition.put("minAge",splitAge[0]);
        try {
            ageCondition.put("maxAge",splitAge[1]);
        }catch(Exception e){
            System.out.println("年龄数组出现索引越界");
        }
        String sex = (String)requestData.get("sex");
        if(sex.equals("全部")){
            sex = "2";
        }else if(sex.equals("男")){
            sex = "0";
        }else{
            sex = "1";
        }
        requestData.put("sexSwitch",sex);
        requestData.put("ageCondition",ageCondition);
        requestData.put("startIndex",(currentPageCondition-1)*dataNumber);
        requestData.put("dataNumber",(dataNumber));
        //按照分页查询员工条件信息
        staffInfo = staffMapper.getStaffInfoConditionPaging(requestData);
        //添加具体分页信息
        List<staff> allStaffInfo = staffMapper.getStaffInfoCondition(requestData);
        Integer count = allStaffInfo.size();
        Integer pagingData = count/8;
        Integer Remainder = count % 8;
        if(Remainder==0){
            for(int i = 0;i<pagingData;i++){
                paging.add(i+1);
            }
        }else{
            for(int i = 0;i<(pagingData+1);i++){
                paging.add(i+1);
            }
        }
        //封装数据
        responseData.put("staffInfo",staffInfo);
        responseData.put("paging",paging);
        return responseData;
    }

    /*
    * 根据员工的员工id删除一条员工信息
    * ZestfulYoghurt
    * 5.20
    * */
    @Override
    public String deleteStaffInfo(String id) {
        staffMapper.deleteStaffInfo(id);
        return "删除成功";
    }

    @Override
    public String updateStaffInfo(Map reqData) {
        String message = "";
        try{
            staffMapper.updateStaffInfo(reqData);
            message = "用户信息修改成功";
        }catch(Exception e){
            message = "用户信息修改失败";
            System.out.println("修改信息失败");
        }
        return message;
    }

    @Override
    public String addStaffInfo(Map reqData) {
        String message = "";
        try{
            staffMapper.addStaffInfo(reqData);
            message = "添加用户信息成功";
        }catch(Exception e){
            message = "添加用户信息失败";
            System.out.println("添加用户信息失败");
        }
        return message;
    }
}
