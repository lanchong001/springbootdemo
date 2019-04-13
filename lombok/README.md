### lombok lombok应用,简化实体类定义,不需要手动编写Get,Set,ToString 等方法
---

注解 | 描述
-- | --
@Setter | 为该类的属性提供set方法
@Getter | 为该类的属性提供get方法
@ToString | 提供toString方法
@EqualsAndHashCode | 提供equals和hashCode方法
@NoArgsConstructor | 无参构造
@AllArgsConstructor | 全参构造
@RequiredArgsConstructor | 制定参数构造
@Cleanup | 注解需要放在流的声明上，再也不用因为忘记finally/try/catch而烦恼了
@Data | 相当于@ToString,@EqualsAndHashCode,Getter以及所有非final字段的@Setter,@RequiredArgsConstructor
@Builder | 建造者模式

---
1. 在pom文件中应用lombok相关的maven依赖包
```
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
```
2. 在对应的实体类上添加需要的注解.比如:@Data
```
    @Data
    public class User {
        private long id;
        private String name;
        private int age;
    }
```
3. 在其他地方就可以直接使用get,set 和 toString 方法了
```
    @RestController
    @RequestMapping("/user")
    public class UserController {
        @GetMapping("lili")
        public String getUser(){
            User user = new User();
            user.setId(1L);
            user.setName("lili");
            user.setAge(18);
            return user.toString();
        }
    }
```