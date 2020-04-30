package com.guanzh.dao;

import com.guanzh.domain.Permission;
import com.guanzh.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    //根据用户id查询所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "com.guanzh.dao.PermissionDao.findPermissionByRoleId"))

    })
    public List<Role> findRoleByUserId(String userId);

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll();

    //添加角色
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    //角色详情查询
    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "com.guanzh.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    @Delete("delete from users_role where roleId = #{roleId}")
    void deleteFromUser_RoleByRoleId(String roleId);

    @Delete("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(String roleId);

    @Delete("delete from role where id = #{roleId}")
    void deleteRoleById(String roleId);
}
