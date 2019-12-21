package com.w.attendance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class EmployeeReq {


    @ApiModelProperty(value = "部门id")
    private Integer deptId;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "岗位id")
    private String jobId;

}
