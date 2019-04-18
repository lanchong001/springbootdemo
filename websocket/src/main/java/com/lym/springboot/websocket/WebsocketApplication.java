package com.lym.springboot.websocket;

import com.lym.springboot.websocket.domain.SocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableScheduling
@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/index")
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
    @SendTo("/topic/callback")
    public Object callback() throws Exception{
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }
}
