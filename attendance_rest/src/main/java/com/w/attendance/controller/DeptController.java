package com.w.attendance.controller;

import com.w.attendance.DeptService;
import com.w.attendance.exception.BaseApiService;
import com.w.attendance.exception.ResponseBase;
import com.w.attendance.request.DeptReq;
import com.w.attendance.request.DeptUpdateReq;
import com.w.attendance.response.DeptListResp;
import com.w.attendance.response.DeptResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "部门接口")
@RestController
@RequestMapping(value = "/{companyId}/dept")
public class DeptController extends BaseApiService{

    @Autowired
    private DeptService deptService;

    @GetMapping("")
    @ApiOperation(value = "部门列表")
    public ResponseBase getDeptList(@PathVariable Integer companyId){
        DeptListResp deptList = deptService.getDeptList(companyId);
        return setResultSuccess(deptList);
    }

    @GetMapping("/{deptId}")
    @ApiOperation(value = "根据部门id查询部门")
    public ResponseBase getDeptById(@PathVariable Integer companyId,@PathVariable Integer deptId){
        DeptResp deptResp = deptService.getDeptById(deptId,companyId);
        return setResultSuccess(deptResp);
    }

    @PostMapping("")
    @ApiOperation(value = "创建部门")
    public ResponseBase addDept(@RequestBody @Valid DeptReq deptReq,@PathVariable Integer companyId){
        DeptResp deptResp = deptService.addDept(deptReq, companyId);
        return setResultSuccess(deptResp);
    }

    @PutMapping("/{deptId}")
    @ApiOperation(value = "修改部门信息")
    public ResponseBase addCompany(@PathVariable Integer companyId,@RequestBody @Valid DeptUpdateReq deptUpdateReq,@PathVariable Integer deptId){
        DeptResp deptResp = deptService.modifyDept(deptUpdateReq, companyId, deptId);
        return setResultSuccess(deptResp);
    }
}
