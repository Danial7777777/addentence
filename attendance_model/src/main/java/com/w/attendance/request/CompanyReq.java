package com.w.attendance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class CompanyReq {

    @NotBlank(message = "公司名称不能为空")
    @ApiModelProperty(value = "公司名称")
    private String name;

}
