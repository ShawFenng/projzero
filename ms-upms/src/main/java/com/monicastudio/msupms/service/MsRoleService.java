package com.monicastudio.msupms.service;

import com.monicastudio.msupms.domain.MsRole;
import com.monicastudio.msupms.mapper.MsRoleMapper;
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
