package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CompanyResp {

    @ApiModelProperty(value = "公司id")
    private Integer id;
    @ApiModelProperty(value = "公司名称")
    private String name;
    @ApiModelProperty(value = "公司状态")
    private Integer status;

}
