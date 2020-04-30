package com.guanzh.service.impl;

import com.guanzh.dao.PermissionDao;
import com.guanzh.domain.Permission;
import com.guanzh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    //查询所有权限
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    //添加权限
    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    //根据id查询权限
    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }
}
