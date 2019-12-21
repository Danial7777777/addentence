package com.w.attendance;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AttendanceGenerator implements ApplicationRunner {
    private static final Logger logger= LoggerFactory.getLogger(AttendanceGenerator.class);

    @Value("${generate}")
    private boolean generate;

    @Autowired
    private MybatisGenerator mybatisGenerator;

    @Override
    public void run(ApplicationArguments args)  {
        if(!generate){
            logger.info("=========== Mybatis-plus 代码生成（开关关闭中） =============");
            return;
        }
        logger.info("=========== Mybatis-plus 代码生成（开始程序） =============");
        // 表名前缀： 前缀在代码生成命名中会被忽略
        String prefix = "";

        // 要生成的表名，可以是多个
/*        String tableName1 = "t_attendance_record";
        String tableName2 = "t_dept";
        String tableName3 = "t_employee";
        String tableName4 = "t_employee_role";
        String tableName5 = "t_job";
        String tableName6 = "t_overtime";
        String tableName7 = "t_overtime_flow";
        String tableName8 = "t_role";
        String tableName9 = "t_rule";*/
        String tableName1 = "t_company";
        // 代码生成路径
        String path = MybatisUtils.generatorPath(false, AttendanceGenerator.class);

        // 代码生成的包名
        String packageName = "com.w.attendance";
        // 一键生成代码 // 注意生成的 entity 的 toString() 方法多了一个 "," 应手动修改
//        mybatisPlusGenerator.generate(path, packageName, prefix, tableName1,tableName2,tableName3,tableName4,tableName5,tableName6,tableName7,tableName8,tableName9);
        mybatisGenerator.generate(path, packageName, prefix, tableName1);
        logger.info("=========== Mybatis-plus 代码生成完毕（结束程序） =============");
    }
}
