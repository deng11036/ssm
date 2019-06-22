package com.itcast.controller;

import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermssion.do")
    public ModelAndView findRoleByIdAndAllPermssion(@RequestParam(name ="id",required = true) String roleid){
        ModelAndView mv = new ModelAndView();
        //查询当前角色信息
         Role role = roleService.findByRoleId(roleid);
        //查询出该角色未关联的权限
        List<Permission> permissionList = roleService.findOtherPermssion(roleid);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleid, @RequestParam(name = "ids",required = true) String[] permissionids){
        roleService.addPermissionToRole(roleid,permissionids);
        return "redirect:findAll.do";
    }
}
