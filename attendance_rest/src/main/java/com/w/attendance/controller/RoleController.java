package com.w.attendance.controller;

import com.w.attendance.RoleService;
import com.w.attendance.exception.BaseApiService;
import com.w.attendance.exception.ResponseBase;
import com.w.attendance.request.RoleReq;
import com.w.attendance.response.RoleListResp;
import com.w.attendance.response.RoleResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "角色接口")
@RestController
@RequestMapping(value = "/{companyId}/role")
public class RoleController extends BaseApiService{

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    @ApiOperation(value = "角色列表")
    public ResponseBase getRoleList(@PathVariable Integer companyId){
        RoleListResp roleList = roleService.getRoleList(companyId);
        return setResultSuccess(roleList);
    }

    @GetMapping("/{roleId}")
    @ApiOperation(value = "根据部门id查询部门")
    public ResponseBase getRoleById(@PathVariable Integer companyId,@PathVariable Integer roleId){
        RoleResp roleResp = roleService.getRoleById(roleId, companyId);
        return setResultSuccess(roleResp);
    }

    @PostMapping("")
    @ApiOperation(value = "创建角色")
    public ResponseBase addRole(@RequestBody @Valid RoleReq roleReq, @PathVariable Integer companyId){
        RoleResp roleResp = roleService.addRole(roleReq, companyId);
        return setResultSuccess(roleResp);
    }

    @PutMapping("/{roleId}")
    @ApiOperation(value = "修改角色")
    public ResponseBase modifyRole(@RequestBody @Valid RoleReq roleReq,@PathVariable Integer roleId){
        RoleResp roleResp = roleService.modifyRole(roleReq, roleId);
        return setResultSuccess(roleResp);
    }
}
