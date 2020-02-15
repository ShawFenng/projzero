package com.monicastudio.msupms.mapper;

import com.monicastudio.msupms.domain.MsRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsRoleMapper {

    List<MsRole> readRolesByUser(String userUuid);
}
