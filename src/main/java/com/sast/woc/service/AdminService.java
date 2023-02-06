package com.sast.woc.service;

import com.sast.woc.common.Result;
import com.sast.woc.mapper.entity.User;

public interface AdminService {

    // 根据用户名删除用户
    Result<String> deleteByUserName(String userName);

    // 根据用户名查找用户
    Result<User> getByUserName(String userName);
}
