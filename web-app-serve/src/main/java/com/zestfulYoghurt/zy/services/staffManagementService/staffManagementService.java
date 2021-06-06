package com.zestfulYoghurt.zy.services.staffManagementService;

import com.zestfulYoghurt.zy.pojos.staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("staffService")
public interface staffManagementService {
    public List<staff> getAllStaffByCondition(Map reqData);
    //普通分页查询员工信息5.20
    public Map getResources(List staffInfo,List paging,Map requestData,Map responseData);
    //根据条件去分页的查询员工信息5.20
    public Map getResourcesByCondition(List staffInfo,List paging,Map requestData,Map responseData);
    //根据id删除员工信息5.20
    public String deleteStaffInfo(String id);
    //根据员工id修改员工信息
    public String updateStaffInfo(Map reqData);
    //添加一条员工信息
    public String addStaffInfo(Map reqData);
}
