package ku.cs.calendar.common;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class Event implements Serializable{
	private int id;
	private Date date;
	private Time time;
	
	public Event(Date date, Time time) {
		id = -1;
		this.date = date;
		this.time = time;
	}
	
	public int checkDayOfMonth(Event event) {
		int dayOfMonth = 0;
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
		}
		return dayOfMonth;
	}
	
	public int checkMonth(Event event) {
		int m = 0;
		if(event.getDate().getMonth().equals("January")) { 
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			m = 12;
		}
		return m;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
