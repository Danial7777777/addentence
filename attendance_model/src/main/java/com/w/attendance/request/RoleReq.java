package com.w.attendance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class RoleReq {



    @ApiModelProperty(value = "角色名")
    private String roleName;

}
