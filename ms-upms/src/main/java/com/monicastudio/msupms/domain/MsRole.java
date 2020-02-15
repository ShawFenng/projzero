package com.monicastudio.msupms.domain;

import com.monicastudio.mscommon.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsRole extends BaseDomain implements GrantedAuthority {

    private String roleName;

    private String roleCode;

    private Integer sort;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}
