package ku.cs.calendar.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			String info = (String) view.getInputPanel().getInfo().getText();

			if (info.equals("")) {
				JOptionPane.showMessageDialog(null, "Please write information in the box.");
			} else {
				Date date = new Date(Integer.parseInt(d), m, Integer.parseInt(y), info);
				Time time = new Time(hr, min);
				Event app = new Event(date, time);
				c.addAppointment(app);
				view.getInputPanel().getSuccess().setText("Success!");
			}

		}
		int count = 0;
		if (source.equals(view.getInputPanel().getShowButton())) {
			String searchD = String.valueOf(view.getInputPanel().getDay2().getSelectedItem());
			String searchM = String.valueOf(view.getInputPanel().getMonth2().getSelectedItem());
			String searchY = String.valueOf(view.getInputPanel().getYear2().getSelectedItem());
			for (int i = 0; i < c.getMyCalendar().size(); i++) {
				if (c.getMyCalendar().get(i).getDate().getDay() == Integer.parseInt(searchD)
						&& c.getMyCalendar().get(i).getDate().getMonth().equals(searchM)
						&& c.getMyCalendar().get(i).getDate().getYear() == Integer.parseInt(searchY)) {
					count+=1;
					JLabel result = new JLabel();
					result.setText(c.getMyCalendar().get(i).getTime().getHr() + ":"
							+ c.getMyCalendar().get(i).getTime().getMin() + "    "
							+ c.getMyCalendar().get(i).getDate().getInfo());

					view.getLogPanel().getShowApp().add(result);
					view.getLogPanel().add(result);

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
			}
		}

		view.pack();
		view.repaint();
	}
}
