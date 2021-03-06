package com.guanzh.dao;

import com.guanzh.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    //通过角色id查询权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findPermissionByRoleId(String id);

    //查询所有权限
    @Select("select * from permission")
    List<Permission> findAll();

    //添加权限
    @Insert("insert into permission (permissionName,url) values(#{permissionName}, #{url})")
    void save(Permission permission);

    @Select("select * from permission where id = #{id}")
    Permission findById(String id);

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteFromRole_Permission(String id);

    @Delete("delete from permission where id = #{id}")
    void deleteById(String id);
}
