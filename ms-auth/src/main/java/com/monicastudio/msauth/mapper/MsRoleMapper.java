package com.monicastudio.msauth.mapper;

import com.monicastudio.msauth.domain.MsRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsRoleMapper {

    List<MsRole> readRolesByUser(String userUuid);
}
