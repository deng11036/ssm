package com.itcast.service;

import com.itcast.domain.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysLogService {

    List<SysLog> findAll();

    public void save(SysLog sysLog);

}
