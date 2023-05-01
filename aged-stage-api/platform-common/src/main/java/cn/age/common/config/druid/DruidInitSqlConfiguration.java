package cn.age.common.config.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidInitSqlConfiguration {

    /**
      * 连接初始化SQL
      */
    private List<String> connectionInitSQLs;
}
