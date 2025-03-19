package com.chatapp.kotane.configuration;

import com.chatapp.kotane.handlers.*;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SignalHandler(), "/broadcast").setAllowedOrigins("*");
    }
}
