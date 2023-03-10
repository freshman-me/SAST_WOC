package com.sast.woc.service;

import com.sast.woc.common.Result;
import com.sast.woc.entity.User;

import java.util.List;

/**
 * @Author xun
 * @create 2023/1/3 16:35
 */
public interface UserService {
    // 这是一个接口的方法，这个方法的具体实现在 UserServiceImpl 里面，你也可以点这个方法左边的小按键进入。
    User sample(String value);

    // 添加用户
    Result<String> addUser(User user);

    // 查找用户
    Result<String> selectUser(String username, String password) throws Exception;

    // 分页查询
    Result<List<User>> selectByPage(Integer pageNum, Integer pageSize);
}
