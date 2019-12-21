package com.w.attendance.controller;

import com.w.attendance.JobService;
import com.w.attendance.exception.BaseApiService;
import com.w.attendance.exception.ResponseBase;
import com.w.attendance.request.JobReq;
import com.w.attendance.request.JobUpdateReq;
import com.w.attendance.response.JobListResp;
import com.w.attendance.response.JobResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "岗位接口")
@RestController
@RequestMapping(value = "/{companyId}/job")
public class JobController extends BaseApiService{

    @Autowired
    private JobService jobService;

    @GetMapping("")
    @ApiOperation(value = "岗位列表")
    public ResponseBase getJobList(@PathVariable Integer companyId){
        JobListResp jobListResp = jobService.getJobList(companyId);
        return setResultSuccess(jobListResp);
    }

    @GetMapping("/{jobId}")
    @ApiOperation(value = "根据岗位id查询岗位")
    public ResponseBase getRoleById(@PathVariable Integer companyId,@PathVariable Integer jobId){
        JobResp jobResp = jobService.getJobById(jobId,companyId);
        return setResultSuccess(jobResp);
    }

    @PostMapping("")
    @ApiOperation(value = "创建岗位")
    public ResponseBase addRole(@RequestBody @Valid JobReq jobReq, @PathVariable Integer companyId){
        JobResp jobResp = jobService.addJob(jobReq, companyId);
        return setResultSuccess(jobResp);
    }

    @PutMapping("/{jobId}")
    @ApiOperation(value = "修改岗位")
    public ResponseBase modifyRole(@RequestBody @Valid JobUpdateReq jobReq, @PathVariable Integer jobId){
        JobResp jobResp = jobService.modifyJob(jobReq, jobId);
        return setResultSuccess(jobResp);
    }
}
