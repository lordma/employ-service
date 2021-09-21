package com.lordma.employ.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/6/19 11:27
 * @Version 1.0
 */
@Data
public class ProjectInfo implements Serializable {
    private static final long serialVersionUID = 7855934411739542370L;
    private Integer projectId;
    private String pCompanyId;
    private Integer endCompanyId;
    private String endCompanyName;
    private Integer jobTypeId;
    private String jobTypeName;
    private String projectName;
    private String address;
    private String comment;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
