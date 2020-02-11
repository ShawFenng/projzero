package com.monicastudio.servicezero.controller;

import com.monicastudio.servicezero.domain.SysUser;
import com.monicastudio.servicezero.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DemoController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public String hello() {
        return "hello, shawn.";
    }

    @GetMapping("sysUser")
    public int saveSysUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("shawn");
        sysUser.setPassword("123456");
        return sysUserService.save(sysUser);
    }

    @GetMapping("white")
    public String white() {
        return "into white";
    }

    @GetMapping("black")
    public String black() {
        return "into black";
    }

}
