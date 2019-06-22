package com.itcast.service.impl;

import com.itcast.dao.RoleDao;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.RoleService;
import org.omg.CORBA.StringHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findById(String userid) {
        return roleDao.findById(userid);
    }

    @Override
    public List<Permission> findOtherPermssion(String roleid) {
        return roleDao.findOtherPermssion(roleid);
    }

    @Override
    public Role findByRoleId(String roleid) {
        return roleDao.findByRoleId(roleid);
    }

    @Override
    public void addPermissionToRole(String roleid, String[] permissionids) {

        for (String permissionid : permissionids) {
            Map<String,String> map = new HashMap<String, String>();
            map.put("roleid",roleid);
            map.put("permissionid",permissionid);
            roleDao.addPermissionToRole(map);
        }
    }
}
