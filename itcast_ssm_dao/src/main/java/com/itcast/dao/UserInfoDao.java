package com.itcast.dao;

import com.itcast.domain.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public UserInfo findByUsername(String username);

    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);
}
