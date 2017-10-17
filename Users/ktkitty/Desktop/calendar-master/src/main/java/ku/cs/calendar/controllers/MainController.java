package ku.cs.calendar.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import ku.cs.calendar.controllers.ButtonListener;
import ku.cs.calendar.models.Event;
import ku.cs.calendar.models.Calendar;
import ku.cs.calendar.views.MainView;
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