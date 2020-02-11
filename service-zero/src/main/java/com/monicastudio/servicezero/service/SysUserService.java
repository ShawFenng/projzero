package com.monicastudio.servicezero.service;

import com.monicastudio.servicezero.domain.SysUser;
import com.monicastudio.servicezero.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    public int save(SysUser sysUser) {
        sysUser.setUuid(UUID.randomUUID().toString());
        return sysUserMapper.insert(sysUser);
    }
}
