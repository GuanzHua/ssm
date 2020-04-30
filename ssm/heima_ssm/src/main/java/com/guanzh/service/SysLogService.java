package com.guanzh.service;

import com.guanzh.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog);

    List<SysLog> findAll();

}
