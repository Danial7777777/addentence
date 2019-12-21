package com.w.attendance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class CompanyListResp {


    @ApiModelProperty(value = "公司列表")
    private List<CompanyResp> companyRespList;
}
