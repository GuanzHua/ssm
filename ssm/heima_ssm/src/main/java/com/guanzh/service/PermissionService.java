package com.guanzh.service;

import com.guanzh.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String id);

    void deleteById(String id);
}
