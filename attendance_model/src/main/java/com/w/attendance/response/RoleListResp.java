package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class RoleListResp {

    @ApiModelProperty(value = "角色列表")
    private List<RoleResp> list;
    
}
