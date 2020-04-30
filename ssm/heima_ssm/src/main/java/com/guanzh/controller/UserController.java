package com.guanzh.controller;

import com.guanzh.domain.Role;
import com.guanzh.domain.UserInfo;
import com.guanzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "ids") String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model, @RequestParam(name = "id") String userId){
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",otherRoles);
        return "user-role-add";
    }


    //查询指定id的用户
    @RequestMapping("findById")
    public String findById(Model model,String id){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }

    //查询所有用户
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<UserInfo> userInfoList =  userService.findAll();
        model.addAttribute("userList",userInfoList);
        return "user-list";
    }

    //添加用户
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }
}
