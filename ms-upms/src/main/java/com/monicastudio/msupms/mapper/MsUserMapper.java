package com.monicastudio.msupms.mapper;

import com.monicastudio.msupms.domain.MsUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsUserMapper {

    int insert(MsUser user);

    int update(MsUser user);

    MsUser readByUsername(String username);

    List<MsUser> readAll();
}
