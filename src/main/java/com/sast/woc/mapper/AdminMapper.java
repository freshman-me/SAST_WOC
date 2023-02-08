package com.sast.woc.mapper;

import com.sast.woc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    
    // 根据用户名查找用户
    User selectUserByUserName(String username);

    // 根据用户名删除用户
    void deleteUserByUserName(String userName);
}
