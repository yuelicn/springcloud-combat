package com.example.screw.config;

import cn.smallbun.screw.core.engine.EngineFileType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author yueli
 * @date 2020/9/22 13:16
 */
@SpringBootTest
public class DocExecuteTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        DataSource dataSourceMysql = applicationContext.getBean(DataSource.class);
        DocExecute.Config config = new DocExecute().new Config();
        config.setDataSource(dataSourceMysql);
        config.setDocName("用户中心数据库字典");
        config.setDescription("用户中心数据库字典文档");
        config.setFileType(EngineFileType.WORD);
        config.setLocalDir("/Users/yueli/work/document");
        config.setVersion("1.0.0");
        config.setIgnoreTableName(Arrays.asList("aa","test_group"));
        config.setIgnorePrefix(Arrays.asList("a","t"));
        config.setIgnoreSuffix(Arrays.asList("_test","czb_"));
        DocExecute.generateDoc(config);

    }
}
