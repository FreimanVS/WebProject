package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value="/chat", configurator= ChatServerEndPointConfigurator.class)
public class ChatServerEndPoint {

    private static final Logger LOGGER = Logger.getLogger(ChatServerEndPoint.class.getName());

    private Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session userSession){
        userSessions.add(userSession);
        LOGGER.log(Level.INFO, "Socket is open!");
    }

    @OnClose
    public void onClose(Session userSession) {
        userSessions.remove(userSession);
        LOGGER.log(Level.INFO, "Socket is closed!");
    }

    @OnMessage
    public void onMessage(String message, Session userSession) {
        LOGGER.log(Level.INFO, "Message Received: " + message);
        for (Session session : userSessions) {
            LOGGER.log(Level.INFO, "Sending to session id: " + session.getId());
            session.getAsyncRemote().sendText(message);
        }
    }
}