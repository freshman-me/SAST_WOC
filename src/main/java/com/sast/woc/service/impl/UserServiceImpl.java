package com.sast.woc.service.impl;

import com.sast.woc.common.Result;
import com.sast.woc.entity.User;
import com.sast.woc.mapper.UserMapper;
import com.sast.woc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author xun
 * @create 2023/1/3 16:35
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 这是sample方法的具体实现
     * @param value value
     * @return User
     */
    @Override
    public User sample(String value) {
        return userMapper.sample(value);
    }

    @Override
    public Result<String> addUser(User user) {
        userMapper.add(user);
        Integer id = user.getId();
        if (id == null)
            return Result.error("注册失败");
        return Result.success("注册成功");
    }
}
