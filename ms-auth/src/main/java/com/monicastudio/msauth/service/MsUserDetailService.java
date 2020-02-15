package com.monicastudio.msauth.service;

import com.monicastudio.msauth.domain.MsRole;
import com.monicastudio.msauth.domain.MsUser;
import com.monicastudio.msauth.mapper.MsUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        roleList.stream().forEach(role -> {
            authorityList.add(role);
        });
        return new User(user.getUsername(), user.getPassword(), roleList);
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
