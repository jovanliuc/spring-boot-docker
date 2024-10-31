## Spring Boot 3.2.2 with DB2 for z/OS and Oracle Integration

以下是使用Spring Boot 3.2.2连接DB2 for z/OS和Oracle数据库的完整配置示例，涵盖依赖项、数据源配置、JPA集成和主要代码实现部分。该示例展示如何在Spring Boot中同时配置两个数据库。

### 1. Maven依赖

在`pom.xml`中，添加以下依赖，涵盖Spring Boot、DB2和Oracle的JDBC驱动以及Jasypt用于加密敏感信息：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.ibm.db2</groupId>
        <artifactId>jcc</artifactId>
        <version>11.5.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
        <version>19.14.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
    </dependency>
    <dependency>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-spring-boot-starter</artifactId>
        <version>3.0.5</version>
    </dependency>
</dependencies>
```

### 2. 配置文件 (`application.yml`)

在`src/main/resources/application.yml`中配置数据源，包含Oracle和DB2的数据源，并使用HikariCP作为连接池。Jasypt用于加密敏感信息，如数据库的用户名和密码。

```yaml
spring:
  datasource:
    db2:
      hikari:
        jdbc-url: jdbc:db2://your-db2-host:50000/your-db2-database
        username: ENC(your-encrypted-db2-username)
        password: ENC(your-encrypted-db2-password)
        driver-class-name: com.ibm.db2.jcc.DB2Driver
        maximum-pool-size: 10  # 设置合理的最大连接数，防止资源过度消耗
        minimum-idle: 2  # 设置最低空闲连接数，以平衡性能和资源占用
        idle-timeout: 300000  # 空闲连接的最大保持时间，单位为毫秒
        max-lifetime: 1800000  # 连接的最大生命周期，单位为毫秒，建议比数据库连接超时时间略短
        connection-timeout: 30000  # 获取连接的最大等待时间，单位为毫秒
        pool-name: DB2HikariPool
        auto-commit: true  # 确保事务自动提交设置为适当值，适用于应用程序场景
        schema: your-db2-default-schema  # 设置默认的schema
    oracle:
      hikari:
        jdbc-url: jdbc:oracle:thin:@your-oracle-host:1521/your-service-name
        username: ENC(your-encrypted-oracle-username)
        password: ENC(your-encrypted-oracle-password)
        driver-class-name: oracle.jdbc.OracleDriver
        maximum-pool-size: 15  # 根据Oracle连接需求设置适当的最大连接数
        minimum-idle: 3  # 设置最低空闲连接数，以确保连接可用性
        idle-timeout: 300000  # 空闲连接的最大保持时间，单位为毫秒
        max-lifetime: 1800000  # 连接的最大生命周期，单位为毫秒
        connection-timeout: 30000  # 获取连接的最大等待时间，单位为毫秒
        pool-name: OracleHikariPool
        auto-commit: true  # 确保事务自动提交设置为适当值，适用于应用程序场景
        schema: your-oracle-default-schema  # 设置默认的schema
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.DB2Dialect, org.hibernate.dialect.Oracle12cDialect
        dialect_resolvers: org.hibernate.dialect.resolver.StandardDialectResolver,org.hibernate.dialect.resolver.DB2DialectResolver,org.hibernate.dialect.resolver.OracleDialectResolver
        format_sql: true  # 格式化SQL输出，使其更易于阅读
        use_sql_comments: true  # 启用SQL注释以便于调试和日志记录

jasypt:
  encryptor:
    password: your-jasypt-encryption-password
    algorithm: PBEWITHHMACSHA512ANDAES_256
    iv-generator-classname: org.jasypt.iv.RandomIvGenerator
```

### 3. 数据源配置类

更新Java配置类以使用`@ConfigurationProperties`从YAML中读取配置，而不是手动在代码中提供数据源信息。

```java
package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class DataSourceConfig {

    @Bean(name = "db2DataSource")
    @Qualifier("db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2.hikari")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleDataSource")
    @Qualifier("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle.hikari")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(db2DataSource());
        em.setPackagesToScan("com.example.demo.model.db2");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(oracleDataSource());
        em.setPackagesToScan("com.example.demo.model.oracle");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager db2TransactionManager() {
        return new JpaTransactionManager(db2EntityManagerFactory().getObject());
    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager oracleTransactionManager() {
        return new JpaTransactionManager(oracleEntityManagerFactory().getObject());
    }
}
```

### 4. 实体类和存储库

分别为Oracle和DB2创建实体类和JPA存储库接口。

```java
package com.example.demo.model.db2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db2_table")
public class DB2Entity {
    @Id
    private Long id;
    private String name;

    // Getters and setters
}
```

```java
package com.example.demo.model.oracle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oracle_table")
public class OracleEntity {
    @Id
    private Long id;
    private String name;

    // Getters and setters
}
```

```java
package com.example.demo.repository;

import com.example.demo.model.db2.DB2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DB2Repository extends JpaRepository<DB2Entity, Long> {
}
```

```java
package com.example.demo.repository;

import com.example.demo.model.oracle.OracleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleRepository extends JpaRepository<OracleEntity, Long> {
}
```

### 5. 调度任务 - 从DB2到Oracle的数据迁移

使用Spring的调度器每天凌晨00:00:00执行数据迁移操作。

```java
package com.example.demo.scheduler;

import com.example.demo.model.db2.DB2Entity;
import com.example.demo.model.oracle.OracleEntity;
import com.example.demo.repository.DB2Repository;
import com.example.demo.repository.OracleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class DataMigrationScheduler {

    @Autowired
    private DB2Repository db2Repository;

    @Autowired
    private OracleRepository oracleRepository;

    @Scheduled(cron = "0 0 0 * * ?")  // 每天凌晨00:00:00执行
    public void migrateDataFromDb2ToOracle() {
        // 从DB2中读取所有数据
        List<DB2Entity> db2Entities = db2Repository.findAll();

        // 遍历DB2的数据并插入到Oracle中
        for (DB2Entity db2Entity : db2Entities) {
            OracleEntity oracleEntity = new OracleEntity();
            oracleEntity.setId(db2Entity.getId());
            oracleEntity.setName(db2Entity.getName());
            oracleRepository.save(oracleEntity);
        }

        System.out.println("Data migration from DB2 to Oracle completed successfully.");
    }
}
```

在这个示例中，`DataMigrationScheduler`类使用Spring的`@Scheduled`注解，每天在凌晨00:00:00执行一次数据迁移任务，从DB2数据库中读取所有记录，并将其插入到Oracle数据库中。
