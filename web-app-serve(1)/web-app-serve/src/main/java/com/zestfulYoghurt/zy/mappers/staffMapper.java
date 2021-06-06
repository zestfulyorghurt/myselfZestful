package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface staffMapper {
    //通过条件查询员工信息Zestful4.27
    public List<staff> getAllStaffByCondition(Map reqData);
    //定义分页查询
    public List<staff> getStaffInfoPaging(Map requestData);
    //获取员工所有信息
    public List<staff> getAllStaffInfo();
    //根据分页查询员工条件信息
    public List<staff> getStaffInfoConditionPaging(Map requestData);
    //根据条件查询员工信息
    public List<staff> getStaffInfoCondition(Map requestData);
    //根据员工id删除一条员工信息
    public void deleteStaffInfo(@Param("id") String id);
    //根据员工id修改员工信息
    public void updateStaffInfo(Map reqData);
    //添加一条员工信息
    public void addStaffInfo(Map reqData);
}
