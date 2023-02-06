package com.sast.woc.controller;

import com.sast.woc.common.Result;
import com.sast.woc.mapper.entity.User;
import com.sast.woc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xun
 * @create 2023/1/3 17:00
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sample")
    public String sample() {
        // 按住 Ctrl 键用鼠标点一下这个方法进里面看看吧。
        return "OK";
    }

    /**
     * 注册功能
     * @param user 收到的用户信息
     * @return 是否成功
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 完成登录功能
     * @param userName 用户名
     * @param password 密码
     * @return 如果登录成功返回 {@code true}, 否则 {@code false}
     */
    @PostMapping("/login")
    public Result<Boolean> login(@RequestParam(defaultValue = "") String userName, @RequestParam(defaultValue = "") String password) {
       log.info("username {}",userName);
       log.info("passowrd {}",password);
        return userService.selectUser(userName,password);
    }

    @GetMapping("/pages")
    public Result<List<User>> getPages(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        return userService.selectByPage(pageNum,pageSize);
    }
}
