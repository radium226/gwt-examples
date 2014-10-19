package radium.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeDateEvent;

public class PersonView extends Composite {
    
    interface PersonViewUiBinder extends UiBinder<Widget, PersonView> {}
    private static PersonViewUiBinder uiBinder = GWT.create(PersonViewUiBinder.class);
    
    
    DateTimePicker startDate;
    
    public PersonView() {
        super();
        
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("startDate")
    public void onChangeDate(ChangeDateEvent event) {
        Window.alert("Bouyaka");
    }
    
    
    
}
