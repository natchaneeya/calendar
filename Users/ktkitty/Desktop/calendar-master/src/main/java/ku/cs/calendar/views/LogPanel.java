/**
 * 
 * Natchaneeya Srithanavanich 5810404987
 */
package ku.cs.calendar.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LogPanel extends JPanel{

	private JButton clearButton;
	private ArrayList<JLabel> showApp;
	private ArrayList<JButton> delEvent;

	
	public LogPanel() {
		showApp = new ArrayList<>();
		delEvent = new ArrayList<>();
		clearButton = new JButton("Clear");
	
	}
	
	public void render(){
		this.setLayout(new GridLayout(10,2,5,10));
		Dimension d = new Dimension(300, 500);
		setSize(d);
		setPreferredSize(d);
		this.setBorder(new TitledBorder(new EtchedBorder(),"Events"));
//		this.setBackground(Color.pink);
		add(clearButton);
	
	    


	}
	public ArrayList<JLabel> getShowApp() {
		return showApp;
	}
	public ArrayList<JButton> getDelEvent() {
		return delEvent;
	}

	public JButton getClearButton() {
		return clearButton;
	}



}
