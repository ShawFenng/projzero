package com.monicastudio.msauth.domain;

import com.monicastudio.mscommon.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsUser extends BaseDomain {

    private String username;

    private String password;

    private String nickName;

    private String email;

    private String phone;

    private String avatar;
}
