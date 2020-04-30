package com.guanzh.service;

import com.guanzh.domain.Permission;
import com.guanzh.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    void deleteRoleById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
