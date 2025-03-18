package com.chatapp.kotane.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.*;
import org.springframework.web.socket.*;
import java.util.*;
import java.util.concurrent.*;;

@Component
public class SignalHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> webSocketSessions = new ConcurrentHashMap<>();

}
