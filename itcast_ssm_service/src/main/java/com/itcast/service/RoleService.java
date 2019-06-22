package com.itcast.service;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    void save(Role role);

    List<Role> findById(String userid);

    List<Permission> findOtherPermssion(String roleid);

    Role findByRoleId(String roleid);

    void addPermissionToRole(String roleid, String[] permissionids);
}
