package com.itcast.dao;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {

    public List<Role> findById(String userId);

    List<Role> findAll();

    void save(Role role);

    List<Permission> findOtherPermssion(String roleid);

   Role findByRoleId(String roleid);

    void addPermissionToRole(Map<String, String> map);
}
