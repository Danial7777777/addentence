package com.w.attendance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.w.attendance.business.DeptEnum;
import com.w.attendance.dao.impl.TDeptDaoImpl;
import com.w.attendance.entity.TDept;
import com.w.attendance.exception.BusinessError;
import com.w.attendance.exception.BusinessException;
import com.w.attendance.request.DeptReq;
import com.w.attendance.request.DeptUpdateReq;
import com.w.attendance.response.DeptListResp;
import com.w.attendance.response.DeptResp;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptService {

    @Autowired
    private TDeptDaoImpl tDeptDao;

    public DeptListResp getDeptList(Integer companyId){
        DeptListResp deptListResp=new DeptListResp();
        List<DeptResp> list=new ArrayList<>();
        EntityWrapper<TDept> tDeptEntityWrapper = new EntityWrapper<>();
        tDeptEntityWrapper.eq("company_id",companyId);
        List<TDept> tCompanies = tDeptDao.selectList(null);
        tCompanies.forEach(tDept-> {
            DeptResp deptResp=new DeptResp();
            BeanUtil.copyProperties(tDept,deptResp);
            list.add(deptResp);
        });
        deptListResp.setDeptRespList(list);
        return deptListResp;
    }


    public DeptResp getDeptById(Integer deptId,Integer companyId){
        DeptResp deptResp=new DeptResp();
        EntityWrapper<TDept> tDeptEntityWrapper = new EntityWrapper<>();
        tDeptEntityWrapper.eq("company_id",companyId);
        tDeptEntityWrapper.eq("id",deptId);
        List<TDept> tDepts = tDeptDao.selectList(tDeptEntityWrapper);
        if (CollectionUtils.isNotEmpty(tDepts)){
            TDept tDept = tDepts.get(0);
            BeanUtil.copyProperties(tDept,deptResp);
        }
        return deptResp;
    }


    public DeptResp addDept(DeptReq deptReq,Integer companyId){
        DeptResp deptResp=new DeptResp();
        TDept tDept = new TDept();
        BeanUtil.copyProperties(deptReq,tDept);
        tDept.setCompanyId(companyId);
        tDept.setStatus(DeptEnum.normal.getCode());
        boolean flag = tDeptDao.insert(tDept);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        BeanUtil.copyProperties(tDept,deptResp);
        return deptResp;
    }

    public DeptResp modifyDept(DeptUpdateReq deptReq, Integer companyId,Integer deptId){
        DeptResp deptResp=new DeptResp();
        EntityWrapper<TDept> tDeptEntityWrapper = new EntityWrapper<>();
        tDeptEntityWrapper.eq("company_id",companyId);
        tDeptEntityWrapper.eq("id",deptId);
        List<TDept> tDepts = tDeptDao.selectList(tDeptEntityWrapper);
        if (CollectionUtils.isNotEmpty(tDepts)){
            TDept tDept = tDepts.get(0);
            BeanUtil.copyProperties(deptReq,tDept,"id","company_id");
            tDeptDao.updateById(tDept);
            BeanUtil.copyProperties(tDept,deptResp);
        }else{
            throw new BusinessException(BusinessError.NO_DEPT);
        }
        return deptResp;
    }

}
