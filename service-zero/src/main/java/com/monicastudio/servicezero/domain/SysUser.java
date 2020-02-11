package com.monicastudio.servicezero.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String uuid;

    private String username;

    private String password;

    private String nickName;

    private String email;

    private String phone;

    private String avatar;
}
