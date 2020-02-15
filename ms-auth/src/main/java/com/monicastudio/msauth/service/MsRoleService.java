package com.monicastudio.msauth.service;

import com.monicastudio.msauth.domain.MsRole;
import com.monicastudio.msauth.mapper.MsRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsRoleService {

    @Autowired
    private MsRoleMapper roleMapper;

    public List<MsRole> readRolesByUser(String userUuid) {
        return roleMapper.readRolesByUser(userUuid);
    }
}
