package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class JobResp{

    @ApiModelProperty(value = "岗位id")
    private Integer id;

    @ApiModelProperty(value = "岗位名称")
    private String jobName;

    @ApiModelProperty(value = "岗位状态")
    private Integer status;

}
