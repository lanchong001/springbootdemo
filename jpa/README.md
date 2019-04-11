### JPA 
---
*  org.hibernate.AnnotationException: No identifier specified for entity: 
```
// import org.springframework.data.annotation.Id;
// 解决办法：  将 import org.springframework.data.annotation.Id; 改为 improt javax.persistence.Id;
improt javax.persistence.Id;

``` 
---
*  Provided id of the wrong type for class com.lym.springboot.jpa.domain.User. Expected: class java.lang.Long, got class java.lang.Integer

```

// public interface UserRepository extends JpaRepository<User,Integer> 

//将 Integer 修改为 Long,   这里的类型应该与 User 中 @Id 注解的字段类型一致
public interface UserRepository extends JpaRepository<User,Long> 

```

---
* org.hibernate.LazyInitializationException: could not initialize proxy
```
//如果是单元测试时，增加 @Transactional 注解
      @Test
      @Transactional
      public void findUserById() throws Exception {
          User user = userRepository.getOne(2L);
          Assert.assertTrue(user != null && user.getName().equals("zhangsan99"));
      }
```
```
      @Test
      public void findUserById() throws Exception {
          User user = userRepository.findAllById(2L).get();
          Assert.assertTrue(user != null && user.getName().equals("zhangsan99"));
      }
```
```
解决LazyInitializationException异常大概有这么几种方式
    1.关闭LazyInitialization, 将fetch设成eager
    2.在spring boot的配置文件application.properties添加spring.jpa.open-in-view=true
    3.用spring 的OpenSessionInViewFilter
    https://www.cnblogs.com/onone/articles/8962914.html
```
