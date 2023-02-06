package com.sast.woc.service.impl;

import com.sast.woc.common.Result;
import com.sast.woc.mapper.entity.User;
import com.sast.woc.mapper.AdminMapper;
import com.sast.woc.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Result<String> deleteByUserName(String userName) {
        if (adminMapper.selectUserByUserName(userName) == null){
            return Result.error("用户名不存在，删除失败");
        }
        adminMapper.deleteUserByUserName(userName);
        return Result.success("删除成功");
    }

    @Override
    public Result<User> getByUserName(String userName) {
       if ( adminMapper.selectUserByUserName(userName) == null) {
           return Result.error("用户不存在");
       }
        return Result.success(adminMapper.selectUserByUserName(userName));
    }
}
