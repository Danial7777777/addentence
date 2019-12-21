package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class EmployeeResp {

    @ApiModelProperty(value = "表id")
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "工号")
    private String jobNumber;

    @ApiModelProperty(value = "部门id")
    private Integer deptId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "岗位id")
    private String jobId;

    @ApiModelProperty(value = "岗位名称")
    private String jobName;

}
