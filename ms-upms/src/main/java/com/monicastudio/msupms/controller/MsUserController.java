package com.monicastudio.msupms.controller;

import com.monicastudio.msauth.domain.MsUser;
import com.monicastudio.msauth.service.MsUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MsUserController {

    @Autowired
    private MsUserDetailService msUserDetailService;

    @PostMapping
    public String save(MsUser msUser) {
        if (msUserDetailService.saveOrUpdate(msUser)) {
            return "success";
        } else {
            return "failure";
        }
    }

    @PutMapping
    public String update(MsUser msUser) {
        if (msUserDetailService.saveOrUpdate(msUser)) {
            return "success";
        } else {
            return "failure";
        }
    }
}
