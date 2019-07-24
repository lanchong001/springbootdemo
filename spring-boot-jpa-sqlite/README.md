1. java.text.ParseException: Unparseable date: "1484236798000" does not match (\p{Nd}++)\Q-\E(\p{Nd}++)\Q-\E(\p{Nd}++)\Q \E(\p{Nd}++)\Q:\E(\p{Nd}++)\Q:\E(\p{Nd}++) 
   my kylin version is 1.6.0
   
   ```
   // 增加date_string_format格式设置  yyyy-MM-dd HH:mm:ss
   spring.datasource.url = jdbc:sqlite:testdb.db?date_string_format=yyyy-MM-dd HH:mm:ss
   ```
   
2. save保存后,java date类型的字段,在数据库中保存为时间戳格式
   ```
   https://codeday.me/bug/20170726/46407.html
   SQlite没有特定的datetime类型。您可以使用TEXT，REAL或INTEGER类型，任何适合您的需要。
   
   java date 类型的字段, sqlite 对应的字段设置为 INTEGER, 即可将数据保存为时间戳格式.
   ```