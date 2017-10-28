/**
 * Natchaneeya Srithanavanich 5810404987
 */
package ku.cs.calendar.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import ku.cs.calendar.client.InputPanel;
import ku.cs.calendar.client.LogPanel;

public class MainView extends JFrame{
	private InputPanel inputPanel;
	private LogPanel logPanel;
	public final int FRAME_WIDTH = 800;
	public final int FRAME_HEIGHT = 600;

	public MainView() {
		inputPanel = new InputPanel();
		inputPanel.render();
		inputPanel.setVisible(true);

		logPanel = new LogPanel();
		logPanel.render();
		logPanel.setVisible(true);

	}

	public void initFrame() {
		Dimension d = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
		setSize(d);
		setPreferredSize(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);

		add(inputPanel, BorderLayout.WEST);
 		add(logPanel, BorderLayout.CENTER);

		pack();

	}
	public InputPanel getInputPanel() {
		return inputPanel;
	}
	public LogPanel getLogPanel() {
		return logPanel;
	}

}
