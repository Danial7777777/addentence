package com.w.attendance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.w.attendance.dao.impl.TRoleDaoImpl;
import com.w.attendance.entity.TRole;
import com.w.attendance.exception.BusinessError;
import com.w.attendance.exception.BusinessException;
import com.w.attendance.request.RoleReq;
import com.w.attendance.response.RoleListResp;
import com.w.attendance.response.RoleResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private TRoleDaoImpl tRoleDao;

    public RoleListResp getRoleList(Integer companyId){

        RoleListResp roleListResp=new RoleListResp();
        List<RoleResp> list=new ArrayList<>();
        EntityWrapper<TRole> entityWrapper=new EntityWrapper<>();
        entityWrapper.eq("company_id",companyId);
        List<TRole> tRoles = tRoleDao.selectList(entityWrapper);
        tRoles.forEach(tRole -> {
            RoleResp roleResp=new RoleResp();
            BeanUtil.copyProperties(tRole,roleResp);
            list.add(roleResp);
        });
        roleListResp.setList(list);
        return roleListResp;
    }


    public RoleResp getRoleById(Integer roleId,Integer companyId){
        RoleResp roleResp=new RoleResp();
        EntityWrapper<TRole> tDeptEntityWrapper = new EntityWrapper<>();
        tDeptEntityWrapper.eq("company_id",companyId);
        tDeptEntityWrapper.eq("id",roleId);
        TRole tRole = tRoleDao.selectOne(tDeptEntityWrapper);
        if (tRole!=null){
            BeanUtil.copyProperties(tRole,roleResp);
        }
        return roleResp;
    }


    public RoleResp addRole(RoleReq roleReq,Integer companyId){
        RoleResp roleResp=new RoleResp();
        TRole tRole = new TRole();
        BeanUtil.copyProperties(roleReq,tRole);
        tRole.setCompanyId(companyId);
        boolean flag = tRoleDao.insert(tRole);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        BeanUtil.copyProperties(tRole,roleResp);
        return roleResp;
    }

    public RoleResp modifyRole(RoleReq roleReq , Integer roleId){
        RoleResp roleResp=new RoleResp();
        EntityWrapper<TRole> tRoleEntityWrapper = new EntityWrapper<>();
        tRoleEntityWrapper.eq("id",roleId);
        TRole tRole = tRoleDao.selectOne(tRoleEntityWrapper);
        if (tRole!=null){
            BeanUtil.copyProperties(roleReq,tRole,"id","company_id");
            tRoleDao.updateById(tRole);
            BeanUtil.copyProperties(tRole,roleResp);
        }else{
            throw new BusinessException(BusinessError.NO_ROLE);
        }
        return roleResp;
    }

}
