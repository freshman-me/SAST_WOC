package com.sast.woc.mapper;

import com.sast.woc.mapper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 示例，可以去resources->mapper中查看UserMapper.xml文件的内容。
    User sample(@Param("value") String value);

    // 根据username搜索用户
    User selectByUserNameUser(String userName);

    // 添加用户
    void add(User user);

    // 根据密码查找用户
    User selectByPasswordUser(String password);

    // 分页查询
    List<User> getUsers(@Param("pageNum")Integer pageNum,@Param("pageSize") Integer pageSize);
}
