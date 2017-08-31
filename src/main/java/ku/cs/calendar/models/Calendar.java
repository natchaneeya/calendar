package ku.cs.calendar.models;

import java.util.ArrayList;

/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class Calendar {
	private ArrayList<Event> myCalendar;
	private Event appointment;

	public Calendar() {
		myCalendar = new ArrayList<>();
		
	}
	public void addAppointment(Event appointment){
		this.appointment = appointment;
		myCalendar.add(appointment);
	
	}
	public String show(){
		return String.format("%s : %s  %s",appointment.getTime().getHr(),appointment.getTime().getMin(), appointment.getDate().getInfo());
	}
	
	public ArrayList<Event> getMyCalendar() {
		return myCalendar;
	}
	
	
}
