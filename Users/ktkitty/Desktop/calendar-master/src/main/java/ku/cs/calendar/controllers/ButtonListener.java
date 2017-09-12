package ku.cs.calendar.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ku.cs.calendar.MyAppTest;
import ku.cs.calendar.models.Event;
import ku.cs.calendar.models.Calendar;
import ku.cs.calendar.models.Date;
import ku.cs.calendar.models.Time;
import ku.cs.calendar.views.MainView;
/**
 * Natchaneeya Srithanavanich 5810404987
 */
public class ButtonListener implements ActionListener {
	private MainView view;
	private Calendar c;
	private DatabaseController db = new DatabaseController();


	public ButtonListener(MainView view, Calendar c) {
		this.view = view;
		this.c = c;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();


		if (source.equals(view.getInputPanel().getAddButton())) {

			String d = (String) view.getInputPanel().getDay().getSelectedItem();
			String m = (String) view.getInputPanel().getMonth().getSelectedItem();
			String y = (String) view.getInputPanel().getYear().getSelectedItem();
			String hr = (String) view.getInputPanel().getHour().getSelectedItem();
			String min = (String) view.getInputPanel().getMin().getSelectedItem();
			String infomation = (String) view.getInputPanel().getInfo().getText();
			String type = (String) view.getInputPanel().getType().getSelectedItem();

			if (infomation.equals("")) {
				JOptionPane.showMessageDialog(null, "Please write information in the box.");
			} else {
				Date date = new Date(Integer.parseInt(d), m, Integer.parseInt(y), infomation);
				Time time = new Time(hr, min);
				Event app = new Event(date, time);
				c.addEvent(app);
//				db.insert(Integer.parseInt(d), m, Integer.parseInt(y), hr, min, infomation);
				if(type.equals("Daily")) {
					c.addDaily(app);
				}else if (type.equals("Weekly")){
					c.addWeekly(app);
				}else if (type.equals("Monthly")){
					c.addMonthly(app);
				}
				view.getInputPanel().getSuccess().setText("Success!");
			}

		}
		int count = 0;
		int countd = 0;
		if (source.equals(view.getInputPanel().getShowButton())) {
			String searchD = String.valueOf(view.getInputPanel().getDay2().getSelectedItem());
			String searchM = String.valueOf(view.getInputPanel().getMonth2().getSelectedItem());
			String searchY = String.valueOf(view.getInputPanel().getYear2().getSelectedItem());
			String h ="";
			String m = "";
			String in = "";
			String typedel = (String) view.getInputPanel().getType().getSelectedItem();
	
			for (int i = 0; i < c.getMyCalendar().size(); i++) {
				if (c.getMyCalendar().get(i).getDate().getDay() == Integer.parseInt(searchD)
						&& c.getMyCalendar().get(i).getDate().getMonth().equals(searchM)
						&& c.getMyCalendar().get(i).getDate().getYear() == Integer.parseInt(searchY)) {
					count+=1;
					
					JLabel result = new JLabel();
					JButton del = new JButton("Delete");
	
							
					h = c.getMyCalendar().get(i).getTime().getHr();
					m = c.getMyCalendar().get(i).getTime().getMin();
					in = c.getMyCalendar().get(i).getDate().getInfo();
					Date d = new Date(Integer.parseInt(searchD), searchM, Integer.parseInt(searchY), in);
					Time t = new Time(h, m);
					
					Event eventdel = new Event(d, t);
					
					result.setText(h + ":" + m + "    " + in);

					view.getLogPanel().getShowApp().add(result);
					view.getLogPanel().add(result);

					view.getLogPanel().getDelEvent().add(del);
					view.getLogPanel().add(del);
					countd+=1;
					int index = countd;
					
					del.addActionListener(new ActionListener() {
						
					
						@Override
						public void actionPerformed(ActionEvent e) {
							view.getLogPanel().remove(view.getLogPanel().getShowApp().get(index -1));
							view.getLogPanel().getShowApp().remove(index-1);
							
							view.getLogPanel().remove(view.getLogPanel().getDelEvent().get(index-1));
							view.getLogPanel().getDelEvent().remove(index-1);
							c.delEvent(eventdel);
							if(typedel.equals("Daily")) {
								c.delDaily(eventdel);
							}else if (typedel.equals("Monthly")) {
								c.delMonthly(eventdel);
							}
							
							view.pack();
							view.repaint();
						}
						
					});
					countd -= 1;
				}

			}
			if(count ==0 ){
				JLabel result = new JLabel();
				result.setText("Nothing to do");

				view.getLogPanel().getShowApp().add(result);
				view.getLogPanel().add(result);
			}
		}
	


		
		if (source.equals(view.getLogPanel().getClearButton())) {
			view.getInputPanel().getInfo().setText("");
			view.getInputPanel().getSuccess().setText("");
			count = 0;

			for (int k = view.getLogPanel().getShowApp().size() - 1; k > -1; k--) {
				view.getLogPanel().remove(view.getLogPanel().getShowApp().get(k));
				view.getLogPanel().getShowApp().remove(k);
				
				if(view.getLogPanel().getDelEvent().size()!=0){
				view.getLogPanel().remove(view.getLogPanel().getDelEvent().get(k));
				view.getLogPanel().getDelEvent().remove(k);
				}
			}
		}

		view.pack();
		view.repaint();
	}
		

}