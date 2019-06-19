package com.itcast.service;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAll();

    void save(Permission permission);
}
