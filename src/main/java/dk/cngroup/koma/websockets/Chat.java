package dk.cngroup.koma.websockets;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author koma
 */
@ServerEndpoint("/hello/{user-name}")
public class Chat {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void login(Session session, @PathParam("user-name") String userName) {
        sessions.add(session);
        session.getUserProperties().put("name", userName);
    }

    @OnClose
    public void logout(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public String broadcast(String message, Session session) throws IOException {
        for (Session client : sessions) {
            if (!client.equals(session)) {
                client.getBasicRemote().sendText(session.getUserProperties().get("name") + ": " + message);
            }
        }
        return "<i>ME: " + message + "</i>";
    }
}
