package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class EmployeeRoleListResp {

    @ApiModelProperty(value = "员工角色关系集合")
    private List<EmployeeRoleResp> list;

}
