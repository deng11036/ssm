package com.itcast.dao;

import com.itcast.domain.SysLog;

import java.util.List;

public interface SysLogDao {
    List<SysLog> findAll();

    void save(SysLog sysLog);
}
