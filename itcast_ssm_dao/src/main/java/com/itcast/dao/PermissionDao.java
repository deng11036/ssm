package com.itcast.dao;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionDao {

    public List<Permission> findById(String id);

    List<Permission> findAll();

    void save(Permission permission);
}
