### 使用JdbcTemplate存在的问题
---
 * 需要自定义Mapper
```
    public class UserRowMapper implements RowMapper<User> {
        @Nullable
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
```
  * 需要自己编写SQL语句
``` 
    public List<User> findUsers() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    } 
``` 

### JdbcTemplate 三种查询方式
---
 * 单值查询
```
    return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
```
 * 单个对象查询
```
     return jdbcTemplate.queryForObject("select * from user where id = ?", new UserRowMapper(),new Object[]{id});
```
 * 对象集合查询
```
    public List<User> findUsers() {
        // JdbcTemplate 查询方式三 : 查询对象集合
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }
```