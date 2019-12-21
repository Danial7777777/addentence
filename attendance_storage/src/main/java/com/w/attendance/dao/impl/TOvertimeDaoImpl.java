package com.w.attendance.dao.impl;

import com.w.attendance.entity.TOvertime;
import com.w.attendance.mapper.TOvertimeMapper;
import com.w.attendance.dao.TOvertimeDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加班表 服务实现类
 * </p>
 *
 * @author yux123
 * @since 2019-12-18
 */
@Service
public class TOvertimeDaoImpl extends ServiceImpl<TOvertimeMapper, TOvertime> implements TOvertimeDao {

}
