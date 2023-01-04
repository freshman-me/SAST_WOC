package com.sast.woc.mapper;

import com.sast.woc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author xun
 * @create 2022/12/26 14:47
 */
@Mapper
@Repository
public interface UserMapper {
    // 示例，可以去resources->mapper中查看UserMapper.xml文件的内容。
    User sample(@Param("value") String value);

    // 根据username搜索用户
    User selectByUserNameUser(String userName);

    // 添加用户
    void add(User user);
}
