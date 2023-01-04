package com.sast.woc.service.impl;

import com.sast.woc.common.Result;
import com.sast.woc.entity.User;
import com.sast.woc.mapper.UserMapper;
import com.sast.woc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
        // 查找用户是否存在
        if (userMapper.selectByUserNameUser(user.getUserName()) != null){
            return Result.error("用户已存在，注册失败");
        }
        // 密码进行md5加密
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);
        user.setRole(0);
        userMapper.add(user);
        Integer id = user.getId();
        if (id == null)
            return Result.error("未知原因,注册失败");
        return Result.success("注册成功");
    }
}
