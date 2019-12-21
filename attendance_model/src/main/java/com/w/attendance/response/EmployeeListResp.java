package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class EmployeeListResp {


    @ApiModelProperty(value = "员工列表")
    private List<EmployeeResp> employeeRespList;
}
