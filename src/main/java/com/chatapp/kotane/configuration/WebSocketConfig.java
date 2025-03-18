package com.chatapp.kotane.configuration;

import com.chatapp.kotane.handlers.*;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final SignalHandler _signalHandler;

    public WebSocketConfig(SignalHandler signalHandler) {
        _signalHandler = signalHandler;
    }

    // @Override
    // public void registerWebSocketHandlers(WebSocketHandlerRegistry
    // handlerRegistry) {
    // handlerRegistry.addHandler(new ConnectionHandler(),
    // "/chat").setAllowedOrigins("*");
    // }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(_signalHandler, "/broadcast").setAllowedOrigins("*");
    }
}
