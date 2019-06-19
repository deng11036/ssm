package com.itcast.service;

import com.itcast.domain.Role;
import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    void save(Role role);
}
