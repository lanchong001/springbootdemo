### spring Boot Java Config 的使用
---
* @Configuration : 标识当前类为一个配置类
* @CompomentScan : 用来扫描指定命名空间下的注解类
* @Import : 用来导入其他的带有@Configuration注解的类(导入其他配置类)
* @ImportResource : 导入xml配置文件
* @Bean : 用来定义一个bean , 可以指定init(),destory()方法,指定bean的范围
