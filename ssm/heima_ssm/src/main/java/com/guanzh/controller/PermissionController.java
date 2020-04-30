package com.guanzh.controller;


import com.guanzh.domain.Permission;
import com.guanzh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //查询所有权限
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Permission> permissionList =  permissionService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission-list";
    }

    //添加权限
    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }

    //根据id查询权限
    @RequestMapping("/findById")
    public String findById(Model model,String id){
        Permission permission = permissionService.findById(id);
        model.addAttribute("permission", permission);
        return "permission-show";
    }

    //根据id删除权限
    @RequestMapping("/deletePermission")
    public String deletePermission(String id){
        permissionService.deleteById(id);
        return "redirect:findAll";
    }
}
