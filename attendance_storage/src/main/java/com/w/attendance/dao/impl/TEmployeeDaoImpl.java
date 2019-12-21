package com.w.attendance.dao.impl;

import com.w.attendance.entity.TEmployee;
import com.w.attendance.mapper.TEmployeeMapper;
import com.w.attendance.dao.TEmployeeDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@Service
public class TEmployeeDaoImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements TEmployeeDao {

}
