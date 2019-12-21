package com.w.attendance;

import cn.hutool.core.bean.BeanUtil;
import com.w.attendance.business.CompanyEnum;
import com.w.attendance.dao.impl.TCompanyDaoImpl;
import com.w.attendance.entity.TCompany;
import com.w.attendance.exception.BusinessError;
import com.w.attendance.exception.BusinessException;
import com.w.attendance.request.CompanyReq;
import com.w.attendance.request.CompanyUpdateReq;
import com.w.attendance.response.CompanyListResp;
import com.w.attendance.response.CompanyResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private TCompanyDaoImpl tCompanyDao;

    public CompanyListResp getCompanyList(){
        CompanyListResp companyListResp=new CompanyListResp();
        List<CompanyResp> list=new ArrayList<>();
        List<TCompany> tCompanies = tCompanyDao.selectList(null);
        tCompanies.forEach(tCompany-> {
            CompanyResp companyResp=new CompanyResp();
            BeanUtil.copyProperties(tCompany,companyResp);
            list.add(companyResp);
        });
        companyListResp.setCompanyRespList(list);
        return companyListResp;
    }

    public CompanyResp getCompanyById(Integer companyId){
        List<CompanyResp> list=new ArrayList<>();
        TCompany tCompany = tCompanyDao.selectById(companyId);
        CompanyResp companyResp=new CompanyResp();
        BeanUtil.copyProperties(tCompany,companyResp);
        return companyResp;
    }


    public CompanyResp addCompany(CompanyReq companyReq){
        TCompany tCompany=new TCompany();
        BeanUtil.copyProperties(companyReq,tCompany);
        tCompany.setStatus(CompanyEnum.normal.getCode());
        boolean flag = tCompanyDao.insert(tCompany);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        CompanyResp companyResp=new CompanyResp();
        BeanUtil.copyProperties(tCompany,companyResp);
        return companyResp;
    }

    public CompanyResp modifyCompany(CompanyUpdateReq companyReq, Integer companyId){
        TCompany tCompany = tCompanyDao.selectById(companyId);
        BeanUtil.copyProperties(companyReq,tCompany,"id");
        boolean flag = tCompanyDao.updateById(tCompany);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        CompanyResp companyResp=new CompanyResp();
        BeanUtil.copyProperties(tCompany,companyResp);
        return companyResp;
    }

}
