package com.w.attendance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel
@Data
public class DeptUpdateReq {

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @NotNull(message = "上级不能为空")
    @ApiModelProperty(value = "上级部门id")
    private Integer parentDeptId;

    @NotNull(message = "状态不能为空")
    @ApiModelProperty(value = "状态")
    private Integer status;
}
