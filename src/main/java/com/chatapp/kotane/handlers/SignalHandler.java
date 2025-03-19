package com.chatapp.kotane.handlers;

import org.springframework.web.socket.handler.*;
import org.springframework.web.socket.*;
import java.util.concurrent.*;

public class SignalHandler extends TextWebSocketHandler {

    private static CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        sessions.add(session);
        session.sendMessage(new TextMessage("connected by " + session.getId()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        sessions.remove(session);
        System.out.println("disconnected by " + session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);

        for (WebSocketSession s : sessions) {
            if (s.isOpen() && s.getId() != session.getId()) {
                s.sendMessage(message);
            }
        }
    }
}
