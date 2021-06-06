package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InterfaceName userMapper
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Mapper
public interface userMapper {
    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 根据条件查询用户
     * @Date 11:30 2021/06/02
     * @Param [requestData]
     * @return void
     **/
    public List<user> select(Map requestData);

    /**
     * @Author ZestfulYoghurt
     * @Description //TODO 添加一条用户信息
     * @Date 17:22 2021/06/04
     * @Param [requestData]
     * @return void
     **/
    public void insert(Map requestData);
}
