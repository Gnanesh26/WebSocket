package com.webSocket.pushNotifications.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // client will connect to our server
        registry.addEndpoint("/stomp-endpoint")
                .withSockJS(); //it enables SockJS fallback options. To keep things short,
        // it will let our WebSockets work even if the WebSocket protocol is not supported by an internet browser.
    }

    @Override
   // Message Broker Configuration: It sets up the message broker for handling the sending and broadcasting of messages.
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//This enables a simple in-memory message broker and sets the destination prefix to "/topic". This means that any message sent to a destination with the "/topic" prefix will be routed to the in-memory message broker.
        registry.setApplicationDestinationPrefixes("/app");//Designates the prefix for messages that are bound for @MessageMapping-annotated methods. This prefix will be used to define all the message mappings. addEndpoint : This will register a WebSocket endpoint that the clients will use to connect to our WebSocket server.
    }
}
