package com.itcast.dao;

import com.itcast.domain.Role;

import java.util.List;

public interface RoleDao {

    public List<Role> findById(String userId);

    List<Role> findAll();

    void save(Role role);
}
