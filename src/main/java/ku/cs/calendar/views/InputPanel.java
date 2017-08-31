/**
 * Natchaneeya Srithanavanich 5810404987
 */
package ku.cs.calendar.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class InputPanel extends JPanel{
	public String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	public String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	public String[] years = {"2017","2018","2019","2020","2021","2022"};
	public String[] hrs = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	public String[] mins = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
	
	private JComboBox<String> day, month, year, hour, min, day2, month2, year2;
	
	private JLabel  addApp,success ,blank1, blank2, time, information, report; 
	private JTextField info;
	private JButton addButton, showButton;
	
	public InputPanel() {
		
		day = new JComboBox<String>(days);
		month = new JComboBox<String>(months);
		year = new JComboBox<String>(years);
		time = new JLabel("Time:");
		hour = new JComboBox<String>(hrs);
		min = new JComboBox<String>(mins);
		information = new JLabel("Information :");
		info = new JTextField(20);
		addApp = new JLabel("Add Appointment");
		addButton = new JButton("Add");
		success = new JLabel("");
		blank1 = new JLabel();
		blank2 = new JLabel();
		
		report = new JLabel("Report Appointment");
		day2 = new JComboBox<String>(days);
		month2 = new JComboBox<String>(months);
		year2 = new JComboBox<String>(years);
		showButton = new JButton("Show!");
		
	}
	
	public void render(){
		this.setLayout(new GridLayout(5,4,2,2));
		Dimension d = new Dimension(500, 400);
		setSize(d);
		setPreferredSize(d);
		this.setBorder(new TitledBorder(new EtchedBorder(),"Add and show appointments"));
		this.setBackground(Color.PINK);
		this.add(addApp);
		this.add(day);
		this.add(month);
		this.add(year);
		this.add(time);
		this.add(hour);
		this.add(min);
		this.add(blank1);
		this.add(information);
		this.add(info);
		this.add(addButton);
		this.add(success);
		
		this.add(report);
		this.add(day2);
		this.add(month2);
		this.add(year2);
	
		this.add(showButton);

	}
	public JComboBox<String> getDay() {
		return day;
	}
	public JComboBox<String> getMonth() {
		return month;
	}
	public JComboBox<String> getYear() {
		return year;
	}
	public JComboBox<String> getHour() {
		return hour;
	}
	public JComboBox<String> getMin() {
		return min;
	}
	public JLabel getTime() {
		return time;
	}
	public JLabel getInformation() {
		return information;
	}
	public JTextField getInfo() {
		return info;
	}
	public JLabel getAddApp() {
		return addApp;
	}
	public JButton getAddButton() {
		return addButton;
	}
	public JLabel getBlank1() {
		return blank1;
	}
	public JLabel getBlank2() {
		return blank2;
	}
	public JLabel getSuccess() {
		return success;
	}
	public JComboBox<String> getDay2() {
		return day2;
	}
	public JComboBox<String> getMonth2() {
		return month2;
	}
	public JComboBox<String> getYear2() {
		return year2;
	}
	public JButton getShowButton() {
		return showButton;
	}
}
