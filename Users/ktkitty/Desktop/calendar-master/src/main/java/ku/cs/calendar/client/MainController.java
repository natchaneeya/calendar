package ku.cs.calendar.client;


import java.io.Serializable;

import ku.cs.calendar.client.ButtonListener;
import ku.cs.calendar.common.Calendar;
/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class MainController  implements Serializable{
	private MainView view;
	private Calendar c;

	
	public MainController() {
		c = new Calendar();
		view = new MainView();
		
	
	}
	
	public void startApplication() {
		view.initFrame();
		ButtonListener buttonListener = new ButtonListener(view, c);
		
		view.getInputPanel().getAddButton().addActionListener(buttonListener);
		view.getInputPanel().getShowButton().addActionListener(buttonListener);
		view.getLogPanel().getClearButton().addActionListener(buttonListener);
		


	}

}