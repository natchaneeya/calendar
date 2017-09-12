package ku.cs.calendar.models;

import java.util.ArrayList;
/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class Event {
	private Date date;
	private Time time;
	
	public Event(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public Time getTime() {
		return time;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}
