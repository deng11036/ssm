package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    public UserInfo findByUsername(String username);

    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRole(String userId);

    void addRoleToUser(Map<String, String> parmtMap);
}
