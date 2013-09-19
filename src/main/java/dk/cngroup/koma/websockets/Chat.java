package dk.cngroup.koma.websockets;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author koma
 */
@ServerEndpoint("/chat/{user-name}")
public class Chat {

    @OnOpen
    public void login(Session session, @PathParam("user-name") String userName) {
        session.getUserProperties().put("name", userName);
    }

    @OnMessage
    public String broadcast(String message, Session session) throws IOException {
        for (Session client : session.getOpenSessions()) {
            if (!client.equals(session)) {
                client.getBasicRemote().sendText(session.getUserProperties().get("name") + ": " + message);
            }
        }
        return "*ME*: " + message;
    }
}
