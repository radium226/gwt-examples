/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radium.server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import radium.server.websocket.SputnikWebSocket;

@WebServlet(name = "Sputnik WebSocket", urlPatterns = {"/sputnik"})
public class SputnikWebSocketServlet extends WebSocketServlet {

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String string) {
        return new SputnikWebSocket();
    }
    
    public void caca() {
        
    }
    
}
