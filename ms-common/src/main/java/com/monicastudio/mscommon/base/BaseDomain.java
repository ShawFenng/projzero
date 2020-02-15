package com.monicastudio.mscommon.base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    private String createBy;

    private LocalDateTime createTime;

    private String modifiedBy;

    private LocalDateTime lastModified;

    private Integer delFlag;
}
