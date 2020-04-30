package com.guanzh.service.impl;

import com.guanzh.dao.RoleDao;
import com.guanzh.domain.Permission;
import com.guanzh.domain.Role;
import com.guanzh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    //查询所有角色
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    //添加角色
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    //角色详情查询
    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    //根据id删除角色
    @Override
    public void deleteRoleById(String roleId) {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
