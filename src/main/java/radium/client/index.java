package radium.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Progress;
import org.gwtbootstrap3.client.ui.ProgressBar;
import org.gwtbootstrap3.client.ui.constants.ProgressBarType;
import org.gwtbootstrap3.client.ui.constants.ProgressType;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class index implements EntryPoint {
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
      final Button button = new Button("Salut! ");
      final FlowPanel panel = new FlowPanel();
      final Progress progress = new Progress();
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
      panel.add(progress);
      RootPanel.get().add(panel);
  }
}
