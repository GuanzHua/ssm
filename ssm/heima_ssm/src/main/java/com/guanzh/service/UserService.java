package com.guanzh.service;

import com.guanzh.domain.Role;
import com.guanzh.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
