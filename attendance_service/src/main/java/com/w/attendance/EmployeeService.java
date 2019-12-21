/*
package com.w.attendance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.w.attendance.business.EmployeeEnum;
import com.w.attendance.dao.impl.TDeptDaoImpl;
import com.w.attendance.dao.impl.TEmployeeDaoImpl;
import com.w.attendance.dao.impl.TEmployeeRoleDaoImpl;
import com.w.attendance.dao.impl.TJobDaoImpl;
import com.w.attendance.entity.TDept;
import com.w.attendance.entity.TEmployee;
import com.w.attendance.entity.TEmployeeRole;
import com.w.attendance.entity.TJob;
import com.w.attendance.exception.BusinessError;
import com.w.attendance.exception.BusinessException;
import com.w.attendance.request.EmployeeReq;
import com.w.attendance.response.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private TEmployeeDaoImpl tEmployeeDao;

    @Autowired
    private TDeptDaoImpl tDeptDao;

    @Autowired
    private TJobDaoImpl tJobDao;

    @Autowired
    private TEmployeeRoleDaoImpl tEmployeeRoleDao;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    */
/**
     * 查询人员信息  带出部门 和岗位
     * @param deptId
     * @param page
     * @param size
     * @return
     *//*

    public EmployeeListResp getEmployeeList(Integer deptId,Integer page,int size){
        EmployeeListResp employeeListResp=new EmployeeListResp();
        List<EmployeeResp> list=new ArrayList<>();
        EntityWrapper<TEmployee> tDeptEntityWrapper = new EntityWrapper<>();
        if (StringUtils.isNotEmpty(deptId+"")){
            tDeptEntityWrapper.eq("dept_id",deptId);
        }
        Page<TEmployee> tEmployeePage = tEmployeeDao.selectPage(new Page<>(page, size), tDeptEntityWrapper);
        if (tEmployeePage.getRecords().size()!=0){
            List<TEmployee> records=tEmployeePage.getRecords();
            for (TEmployee record : records) {
                EmployeeResp employeeResp=new EmployeeResp();
                BeanUtil.copyProperties(record,employeeResp);
                //查询部门
                TDept tDept = tDeptDao.selectById(record.getDeptId());
                employeeResp.setDeptName(tDept.getDeptName());
                //查询岗位
                TJob tJob = tJobDao.selectById(record.getJob_id());
                employeeResp.setJobName(tJob.getJobName());
                list.add(employeeResp);
            }
        }
        employeeListResp.setEmployeeRespList(list);
        return employeeListResp;
    }

    */
/**
     * 根据员工id  查询员工
     * @param emloyeeId
     * @return
     *//*

    public EmployeeResp getEmployeeById(Integer emloyeeId){
        EmployeeResp employeeResp=new EmployeeResp();
        EntityWrapper<TEmployee> tEmployeeEntityWrapper = new EntityWrapper<>();
        tEmployeeEntityWrapper.eq("id",emloyeeId);
        TEmployee tEmployee = tEmployeeDao.selectOne(tEmployeeEntityWrapper);
        if (tEmployee==null){
            throw new BusinessException(BusinessError.NO_EMPLOYRR);
        }
        BeanUtil.copyProperties(tEmployee,employeeResp);
        return employeeResp;
    }

    */
/**
     * 添加员工
     * @param employeeReq
     * @param companyId
     * @return
     *//*

    public EmployeeResp addEmployee(EmployeeReq employeeReq, Integer companyId){
        EmployeeResp employeeResp=new EmployeeResp();
        TEmployee tEmployee = new TEmployee();
        BeanUtil.copyProperties(employeeReq,tEmployee);
        tEmployee.setCompanyId(companyId);
        tEmployee.setStatus(EmployeeEnum.normal.getCode());
        boolean flag = tEmployeeDao.insert(tEmployee);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        BeanUtil.copyProperties(tEmployee,employeeResp);
        return employeeResp;
    }

    */
/**
     * 为员工配置角色
     * @param companyId
     * @param roleId
     * @param employeeId
     * @return
     *//*

    public EmployeeRoleResp configEmployeeRole(Integer companyId,Integer roleId, Integer employeeId){
        EmployeeRoleResp employeeRoleResp=new EmployeeRoleResp();
        TEmployeeRole tEmployeeRole = new TEmployeeRole();
        EmployeeResp employeeResp = employeeService.getEmployeeById(employeeId);
        if (employeeResp==null){
            throw new BusinessException(BusinessError.NO_EMPLOYRR);
        }
        RoleResp roleResp = roleService.getRoleById(roleId, companyId);
        if (roleResp==null){
            throw new BusinessException(BusinessError.NO_ROLE);
        }
        tEmployeeRole.setEmployeeId(employeeId);
        tEmployeeRole.setRoleId(roleId);
        boolean flag = tEmployeeRoleDao.insert(tEmployeeRole);
        if (!flag){
            throw new BusinessException(BusinessError.DB_ERROR);
        }
        BeanUtil.copyProperties(tEmployeeRole,employeeRoleResp);
        employeeRoleResp.setName(employeeResp.getName());
        employeeRoleResp.setRoleName(roleResp.getRoleName());
        return employeeRoleResp;
    }

    */
/**
     * 获得员工所有角色
     * @param employeeId
     * @param companyId
     * @return
     *//*

    public EmployeeRoleListResp getEmployeeRole(Integer employeeId,Integer companyId){

        EmployeeRoleListResp employeeRoleListResp=new EmployeeRoleListResp();
        List<EmployeeRoleResp> list=new ArrayList<>();

        EmployeeResp employeeResp = employeeService.getEmployeeById(employeeId);
        if (employeeResp==null){
            throw new BusinessException(BusinessError.NO_EMPLOYRR);
        }
        EntityWrapper<TEmployeeRole> employeeRoleEntityWrapper=new EntityWrapper<>();
        List<TEmployeeRole> tEmployeeRoles = tEmployeeRoleDao.selectList(employeeRoleEntityWrapper);
        for (TEmployeeRole employeeRole : tEmployeeRoles) {
            EmployeeRoleResp employeeRoleResp=new EmployeeRoleResp();
            BeanUtil.copyProperties(employeeRole,employeeRoleResp);
            Integer roleId = employeeRoleResp.getToleId();
            RoleResp roleResp = roleService.getRoleById(roleId, companyId);
            employeeRoleResp.setRoleName(roleResp.getRoleName());
            employeeRoleResp.setName(employeeResp.getName());
            list.add(employeeRoleResp);
        }
        employeeRoleListResp.setList(list);
        return employeeRoleListResp;
    }



    public EmployeeResp modifyEmployee(EmployeeReq employeeReq, Integer companyId,Integer employeeId){
        EmployeeResp employeeResp = getEmployeeById(employeeId);
        if (employeeResp!=null){
            TEmployee tEmployee = new TEmployee();
            BeanUtil.copyProperties(employeeResp,tEmployee);
            boolean flag = tEmployeeDao.updateById(tEmployee);
            if (!flag){
                throw new BusinessException(BusinessError.DB_ERROR);
            }
        }

        EmployeeResp employeeResp=new EmployeeResp();
        TEmployee tEmployee = new TEmployee();
        BeanUtil.copyProperties(employeeReq,tEmployee);


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
*/
