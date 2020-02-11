package com.monicastudio.servicezero.mapper;

import com.monicastudio.servicezero.domain.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    int insert(SysUser sysUser);

    List<SysUser> readAll();
}
