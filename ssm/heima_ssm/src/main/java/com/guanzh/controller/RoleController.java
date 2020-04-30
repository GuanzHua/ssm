package com.guanzh.controller;

import com.guanzh.domain.Permission;
import com.guanzh.domain.Role;
import com.guanzh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionIds){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll";
    }

    //根据roleId查询role,并查询出可以添加的权限信息
    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(Model model,@RequestParam(name = "id") String roleId){
        //根据roleId查询role
        Role role = roleService.findById(roleId);

        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",otherPermissions);

        return "role-permission-add";
    }

    //查询所有角色
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }

    //添加角色
    @RequestMapping("save")
    public String save(Model model, Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    //角色详情查询
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(name = "id") String roleId){
        Role role = roleService.findById(roleId);
        model.addAttribute("role",role);
        return "role-show";
    }

    //根据id删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam(name = "id") String roleId){
        roleService.deleteRoleById(roleId);
        return "redirect:findAll";
    }

}
