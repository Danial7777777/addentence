package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class EmployeeRoleResp {

    @ApiModelProperty(value = "表id")
    private Integer employeeId;

    @ApiModelProperty(value = "员工名称")
    private String name;

    @ApiModelProperty(value = "角色id")
    private Integer toleId;

    @ApiModelProperty(value = "角色名")
    private String roleName;

}
