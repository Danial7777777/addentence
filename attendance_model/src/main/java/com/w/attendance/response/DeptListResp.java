package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class DeptListResp {


    @ApiModelProperty(value = "部门列表")
    private List<DeptResp> deptRespList;
}
