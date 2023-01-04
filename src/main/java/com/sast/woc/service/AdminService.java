package com.sast.woc.service;

import com.sast.woc.common.Result;

public interface AdminService {

    Result<String> deleteByUserName(String userName);
}
