package com.guanzh.dao;

import com.guanzh.domain.Role;
import com.guanzh.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.guanzh.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    //查询所有用户
    @Select("select * from users")
    List<UserInfo> findAll();

    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) " +
            " values(#{email},#{username},#{password},#{phoneNum},#{status}) ")
    void save(UserInfo userInfo);

    //查询指定id的用户
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.guanzh.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId}) ")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
