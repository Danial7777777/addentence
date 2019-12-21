package com.w.attendance.controller;

import com.w.attendance.CompanyService;
import com.w.attendance.exception.BaseApiService;
import com.w.attendance.exception.ResponseBase;
import com.w.attendance.request.CompanyReq;
import com.w.attendance.request.CompanyUpdateReq;
import com.w.attendance.response.CompanyListResp;
import com.w.attendance.response.CompanyResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "公司接口",value = "公司接口")
@RestController
@RequestMapping(value = "/company")
public class CompanyController extends BaseApiService{

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    @ApiOperation(value = "公司列表")
    public ResponseBase getCompanyList(){
        CompanyListResp companyList = companyService.getCompanyList();
        return setResultSuccess(companyList);
    }

    @GetMapping("/{companyId}")
    @ApiOperation(value = "根据公司id查询公司信息")
    public ResponseBase getCompanyById(@PathVariable Integer companyId){
        CompanyResp companyResp = companyService.getCompanyById(companyId);
        return setResultSuccess(companyResp);
    }

    @PostMapping("")
    @ApiOperation(value = "创建公司")
    public ResponseBase addCompany(@RequestBody @Valid CompanyReq companyReq){
        CompanyResp companyResp = companyService.addCompany(companyReq);
        return setResultSuccess(companyResp);
    }

    @PutMapping("/{companyId}")
    @ApiOperation(value = "修改公司信息")
    public ResponseBase addCompany(@PathVariable Integer companyId,@RequestBody @Valid CompanyUpdateReq companyReq){
        CompanyResp companyResp = companyService.modifyCompany(companyReq,companyId);
        return setResultSuccess(companyResp);
    }

}
