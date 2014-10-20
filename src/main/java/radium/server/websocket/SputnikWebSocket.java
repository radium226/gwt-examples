/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radium.server.websocket;

import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.WebSocket;

/**
 *
 * @author adrien
 */
public class SputnikWebSocket implements WebSocket.OnTextMessage {

    private WebSocket.Connection connection;
    
    public SputnikWebSocket() {
        super();
    }
    
    @Override
    public void onMessage(String message) {
        System.out.println(" --> message");
    }

    @Override
    public void onOpen(Connection connection) {
        System.out.println(" --> onOpen");
        this.connection = connection;
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        SputnikWebSocket.this.connection.sendMessage("Bip! ");
                    } catch (IOException e) {
                        e.printStackTrace(System.err);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        
                    }
                }
            }
            
        }).start();
    }

    @Override
    public void onClose(int i, String string) {
        System.out.println(" --> onClose");
    }
    
}
