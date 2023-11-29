package com.webSocket.pushNotifications.Controller;

import com.webSocket.pushNotifications.Greeting;
import com.webSocket.pushNotifications.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

 // Spring’s approach to working with STOMP messaging is to associate a controller method to the configured endpoint. We can do this through the @MessageMapping annotation
    @MessageMapping("/hello") // Defines which messages will a given Controller's method receive


   // This annotation, when combined with @MessageMapping , establishes a comprehensive mapping of the incoming request and its subsequent response.
    @SendTo("/topic/greetings")//provides a declarative approach to specify the destination where the response message should be routed.

    public Greeting greet(HelloMessage message){
        return  new Greeting("Hello,"+HtmlUtils.htmlEscape(message.getName()));

    }
}
