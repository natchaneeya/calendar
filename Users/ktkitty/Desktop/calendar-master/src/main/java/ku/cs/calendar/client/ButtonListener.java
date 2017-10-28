package ku.cs.calendar.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ku.cs.calendar.common.Calendar;
import ku.cs.calendar.common.DataSource;
import ku.cs.calendar.common.Date;
import ku.cs.calendar.common.Event;
import ku.cs.calendar.common.Time;
/**
 * Natchaneeya Srithanavanich 5810404987
 */
public class ButtonListener implements ActionListener {
	private MainView view;
	private Calendar c;
	private DataSource dataSource;


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
				c.addEvent(app, type);
				view.getInputPanel().getSuccess().setText("Success!");
			}

		}
		int count = 0;
		int countd = 0;
		if (source.equals(view.getInputPanel().getShowButton())) {
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
		

			view.pack();
			view.repaint();
			
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
							c.delEvent(eventdel, typedel);
							
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