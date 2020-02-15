package com.monicastudio.msupms.service;

import com.monicastudio.msupms.domain.MsRole;
import com.monicastudio.msupms.domain.MsUser;
import com.monicastudio.msupms.mapper.MsUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MsUserDetailService implements UserDetailsService {

    @Autowired
    private MsUserMapper userMapper;
    @Autowired
    private MsRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MsUser user = userMapper.readByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在或用户名/密码错误。");
        }

        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<MsRole> roleList = roleService.readRolesByUser(user.getUuid());
        roleList.forEach(role -> {
            authorityList.add(role);
        });
        return new User(user.getUsername(), user.getPassword(), authorityList);
    }

    public boolean saveOrUpdate(MsUser user) {
        boolean updateFlag = true;

        if (StringUtils.isEmpty(user.getUuid())) {
            user.setUuid(UUID.randomUUID().toString());
            updateFlag = false;
        }

        if (!StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }

        return (updateFlag ? userMapper.update(user) : userMapper.insert(user)) > 0;
    }

}
