package radium.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Progress;
import org.gwtbootstrap3.client.ui.ProgressBar;
import org.gwtbootstrap3.client.ui.constants.ProgressBarType;
import org.gwtbootstrap3.client.ui.constants.ProgressType;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.realityforge.gwt.websockets.client.WebSocket;
import org.realityforge.gwt.websockets.client.WebSocketListener;
import radium.client.ui.PersonView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class index implements EntryPoint, GWT.UncaughtExceptionHandler {
    
     private static Logger LOGGER  = Logger.getLogger(index.class.getName());
    
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
      LOGGER.info("Hello! ");
      GWT.setUncaughtExceptionHandler(this);
       //final Button button = new Button("Salut! ");
      final FlowPanel panel = new FlowPanel();
      /*final Progress progress = new Progress();
      progress.setType(ProgressType.STRIPED);
      progress.setActive(true);
      final ProgressBar bar = new ProgressBar();
      bar.setPercent(0);
      progress.add(bar);
      button.addClickHandler(new ClickHandler() {

          @Override
          public void onClick(ClickEvent event) {
              bar.setPercent(bar.getPercent() + 10);
          }
          
      });
      panel.add(button);
      panel.add(progress);*/
      WebSocket webSocket = WebSocket.newWebSocketIfSupported(); //https://github.com/realityforge/gwt-websockets
      webSocket.setListener(new WebSocketListener() {

          @Override
          public void onOpen(WebSocket webSocket) {
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void onClose(WebSocket webSocket, boolean wasClean, int code, String reason) {
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }

          @Override
          public void onMessage(WebSocket webSocket, String data) {
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              Window.alert(data);
          }

          @Override
          public void onMessage(WebSocket webSocket, ArrayBuffer data) {
              Window.alert(data.toString());
          }

          @Override
          public void onError(WebSocket webSocket) {
              LOGGER.log(Level.WARNING, "Something happend with the WebSocket... ");
          }
      });
      webSocket.connect("ws://127.0.0.1:8888/sputnik");
      panel.add(new PersonView());
      RootPanel.get().add(panel);
  }

    @Override
    public void onUncaughtException(Throwable e) {
        LOGGER.log(Level.WARNING, e.getMessage(), e);
    }
    
    
}
