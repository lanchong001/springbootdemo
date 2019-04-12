### jpa durid yml 配置文件的方式
---
1. 引入druid相关的依赖
```
    <!-- 引入druid依赖 -->
    <!-- 此处的引用有两种 -->
    <!-- 一种是直接引用druid包,另一种是引用starter方式 -->
    <!-- 在此处我引用的是start包,为什么呢，因为方便呀... -->
    <!-- 注:如果没有该包,application.properties/application.yml 中将不会出现关于druid的提示 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.10</version>
    </dependency>
```
2. application.yml中增加druid相关的配置
```
#定义 datasource 类型
    type: com.alibaba.druid.pool.DruidDataSource
#druid 连接池的设置
    druid:
#初始化时建立物理连接的个数
      initial-size: 5
#最小连接池数量
      min-idle: 5
#最大连接池数量 maxIdle已经不再使用
      max-active: 20
#获取连接时最大等待时间，单位毫秒
      max-wait: 60000
#申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
      test-while-idle: true
#既作为检测的间隔时间又作为testWhileIdel执行的依据
      time-between-eviction-runs-millis: 60000
#销毁线程时检测当前连接的最后活动时间和当前时间差大于该值时，关闭当前连接
      min-evictable-idle-time-millis: 30000
#申请连接时会执行validationQuery检测连接是否有效,开启会降低性能,默认为true
      test-on-borrow: false
#归还连接时会执行validationQuery检测连接是否有效,开启会降低性能,默认为true
      test-on-return: false
#当数据库抛出不可恢复的异常时,抛弃该连接
      exception-sorter: com.alibaba.druid.pool.vendor.MySqlExceptionSorter
#是否缓存preparedStatement,mysql5.5+建议开启
      pool-prepared-statements: true
#当值大于0时poolPreparedStatements会自动修改为true
      max-pool-prepared-statement-per-connection-size: 20
#配置扩展插件
      filters: stat,wall
#通过connectProperties属性来打开mergeSql功能；慢SQL记录
      connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
#合并多个DruidDataSource的监控数据
      use-global-data-source-stat: true
#设置访问druid监控页的账号和密码,默认没有
      stat-view-servlet:
        login-username: admin
        login-password: admin
#jpa设置
  jpa:
    database: mysql
    show-sql: true
    hibernate:
      ddl-auto: update
```
3. 启动Web项目，访问 http://localhost:8080/druid 查看 druid 相关的监控信息
