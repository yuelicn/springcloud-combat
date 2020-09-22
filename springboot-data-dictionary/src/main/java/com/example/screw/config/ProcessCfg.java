package com.example.screw.config;

import cn.smallbun.screw.core.process.ProcessConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yueli
 * @date 2020/9/22 12:57
 */
public class ProcessCfg {

    /**
     * 配置想要生成的表+ 配置想要忽略的表
     *
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig(DocExecute.Config config) {
        // 忽略表名
        List<String> ignoreTableName = config.getIgnoreTableName();
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = config.getIgnorePrefix();
        // 忽略表后缀
        List<String> ignoreSuffix = config.getIgnoreSuffix();

        return ProcessConfig.builder()
                //根据名称指定表生成
                .designatedTableName(new ArrayList<>())
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
    }
}
