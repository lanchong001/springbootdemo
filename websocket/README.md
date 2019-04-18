### WebSocket 的 应用
---
https://segmentfault.com/a/1190000016012270
http://blog.healerjean.com/websocket/2018/03/28/2_%E7%82%B9%E5%AF%B9%E7%82%B9%E5%BC%8FWebSocket/#%E4%BB%A3%E7%A0%81%E4%B8%8B%E8%BD%BD
https://www.cnblogs.com/GoodHelper/p/7078381.html

https://spring.io/guides/gs/messaging-stomp-websocket/
---
1. POM文件引入相关jar包
```
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-websocket</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
```
2. 定义 WebSocket 配置类
```
package com.lym.springboot.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/user");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS();
    }

}
```

3. 定义消息实体类
```
package com.lym.springboot.websocket.domain;
import lombok.Data;

@Data
public class SocketMessage {
    public String message;
    public String date;
}
```

4. 定义启动类,定时给客户端发送消息,调用客户端请求
```
@Controller
@EnableScheduling
@SpringBootApplication
public class WebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    /**
     *  接收客户端发送过来的websocket请求
     */
    @MessageMapping("/send")
    @SendTo
    public SocketMessage send(SocketMessage socketMessage) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        socketMessage.date = dateFormat.format(new Date());
        return socketMessage;
    }

    /**
     *  启用spring boot的定时任务，这与“callback”方法相呼应，用于每隔1秒推送服务器端的时间
     * @return
     * @throws Exception
     */
    @Scheduled(fixedDelay = 1000)
    @SendTo("topic/callback")
    public Object callback() throws Exception{
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }
}
```
5. 定义 WebSocket 客户端 Js访问代码
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>websocket</title>
    <script th:src="@{sockjs.min.js}"></script>
    <script th:src="@{stomp.min.js}"></script>
    <script th:src="@{jquery.js}"></script>
    <script th:inline="javascript">

        var stompClient = null;

        //连接
        function connect() {
            var sock = new SockJS("/websocket");
            stompClient = Stomp.over(sock);
            stompClient.connect('guest', 'guest', function (frame) {
                // 注册发送消息
                stompClient.subscribe('/user/topic/send', function (msg) {
                    var row = JSON.parse(msg.body);
                    var trHtml = "<tr><td>" + row.message + "</td><td> " + row.date + "</td></tr>";
                    $("#table1 tbody").append(trHtml);
                });
                // 注册推送时间回调
                stompClient.subscribe('/user/topic/callback', function (r) {
                    $('#data_time').text('当前服务器时间：' + r.body);
                });
            });
        }

        //断开连接
        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
        }

        //发送消息
        function send() {
            stompClient.send("/user/app/send", {}, JSON.stringify({
                'message': $("#message").val()
            }));
        }
    </script>
</head>
<body>

<label>WebSocket连接状态:</label>
<button type="button" click="connect()">连接</button>
<button type="button" click="disconnect()">断开</button>
<br/>
<br/>
<div>
    <label id="data_time"></label> <br/> <br/>
    <input type="text" id="message" placeholder="请输入内容..."/>
    <button click="send()" type="button">发送</button>
    <br/> <br/> 消息列表： <br/>
    <table id="table1">
        <thead>
        <tr>
            <th>内容</th>
            <th>时间</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
</body>
</html>
```

---
#### Uncaught SyntaxError: Unexpected token <
1. spring boot 默认拦截了js , 增加 WebMvcConfig.java 处理静态资源
2. https://www.cnblogs.com/sxdcgaq8080/p/6743638.html
