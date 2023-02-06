package com.sast.woc.controller;

import com.sast.woc.common.Result;
import com.sast.woc.mapper.entity.User;
import com.sast.woc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xun
 * @create 2023/1/3 17:13
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 根据用户名删除用户
     * @param userName 用户名
     * @return 删除成功返回 success
     */
    @GetMapping("/del_user")
    public Result<String> delUser(String userName) {
        return adminService.deleteByUserName(userName);
    }

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return User
     */
    @GetMapping("/find_user_info")
    public Result<User> findUser(String userName) {
        // todo 补全代码，你需要去掉下面的 null
        return adminService.getByUserName(userName);
    }
}
