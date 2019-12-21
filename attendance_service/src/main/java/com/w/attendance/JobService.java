package com.w.attendance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.w.attendance.dao.impl.TJobDaoImpl;
import com.w.attendance.entity.TJob;
import com.w.attendance.exception.BusinessError;
import com.w.attendance.exception.BusinessException;
import com.w.attendance.request.JobReq;
import com.w.attendance.request.JobUpdateReq;
import com.w.attendance.response.JobListResp;
import com.w.attendance.response.JobResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private TJobDaoImpl tJobDao;

    public JobListResp getJobList(Integer companyId){
        JobListResp jobListResp=new JobListResp();
        List<JobResp> list=new ArrayList<>();
        EntityWrapper<TJob> entityWrapper=new EntityWrapper<>();
        entityWrapper.eq("company_id",companyId);
        List<TJob> tJobs = tJobDao.selectList(entityWrapper);
        tJobs.forEach(tJob -> {
            JobResp jobResp=new JobResp();
            BeanUtil.copyProperties(tJob,jobResp);
            list.add(jobResp);
        });
        jobListResp.setJobRespList(list);
        return jobListResp;
    }


    public JobResp getJobById(Integer jobId,Integer companyId){
        JobResp jobResp=new JobResp();
        EntityWrapper<TJob> tDeptEntityWrapper = new EntityWrapper<>();
        tDeptEntityWrapper.eq("company_id",companyId);
        tDeptEntityWrapper.eq("id",jobId);
        TJob tJob = tJobDao.selectOne(tDeptEntityWrapper);
        if (tJob!=null){
            BeanUtil.copyProperties(tJob,jobResp);
        }
        return jobResp;
    }



    public JobResp addJob(JobReq jobReq, Integer companyId){
        JobResp jobResp=new JobResp();
        TJob tJob = new TJob();
        BeanUtil.copyProperties(jobReq,tJob);
        tJob.setCompanyId(companyId);
        boolean flag = tJobDao.insert(tJob);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        BeanUtil.copyProperties(tJob,jobResp);
        return jobResp;
    }

    public JobResp modifyJob(JobUpdateReq jobUpdateReq,Integer jobId){
        JobResp jobResp=new JobResp();
        EntityWrapper<TJob> tRoleEntityWrapper = new EntityWrapper<>();
        tRoleEntityWrapper.eq("id",jobId);
        TJob tJob = tJobDao.selectOne(tRoleEntityWrapper);
        if (tJob!=null){
            BeanUtil.copyProperties(jobUpdateReq,tJob,"id","company_id");
            tJobDao.updateById(tJob);
            BeanUtil.copyProperties(tJob,jobResp);
        }else{
            throw new BusinessException(BusinessError.NO_JOB);
        }
        return jobResp;
    }

}
