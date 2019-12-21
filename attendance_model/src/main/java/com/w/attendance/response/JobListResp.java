package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class JobListResp {

    @ApiModelProperty(value = "岗位列表")
    private List<JobResp> jobRespList;


}
