package com.w.attendance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class JobReq {



    @ApiModelProperty(value = "岗位名称")
    private String jobName;


}
