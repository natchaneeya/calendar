package ku.cs.calendar.models;

import java.util.ArrayList;

import ku.cs.calendar.controllers.DatabaseController;

/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class Calendar {
	private ArrayList<Event> myCalendar;
	private Event event;
	private DatabaseController db = new DatabaseController();
	

	public Calendar() {
		myCalendar = new ArrayList<>();
		myCalendar = db.select();
		
	}
	public void addEvent(Event event){
		this.event = event;
		myCalendar.add(event);
		db.insert(event.getDate().getDay(), event.getDate().getMonth(),event.getDate().getYear(), event.getTime().getHr(), event.getTime().getMin(), event.getDate().getInfo());
		
	}

	
	public void delEvent(Event event){
		this.event = event;
		for (int i = 0; i < myCalendar.size(); i++) {
			if (event.getDate().getDay() == myCalendar.get(i).getDate().getDay() &&
					event.getDate().getMonth().equals(myCalendar.get(i).getDate().getMonth()) &&
					event.getDate().getYear() == myCalendar.get(i).getDate().getYear() &&
					event.getTime().getHr().equals(myCalendar.get(i).getTime().getHr()) &&
					event.getTime().getMin().equals(myCalendar.get(i).getTime().getMin()) &&
					event.getDate().getInfo().equals(myCalendar.get(i).getDate().getInfo()) ){
				myCalendar.remove(i);
				db.delete(event.getDate().getDay(), event.getDate().getMonth(),event.getDate().getYear(), event.getTime().getHr(), event.getTime().getMin(), event.getDate().getInfo());
			}
		}
	}
	/**
	 * repeat daily that year only
	 * @param event
	 */
	
	public void addDaily(Event event) {
		this.event = event;
		int d = event.getDate().getDay();
		int dayOfMonth =0;
		int m = 0;
		String mon = "";
		boolean check = false;
		Time time = new Time(event.getTime().getHr(), event.getTime().getMin());
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
			m = 12;
		}
		for (int i = m; i <= 12; i++) {
			if(i==1) { mon = "January";}
			else if(i==2) { mon = "February";}
			else if(i==3) { mon = "March";}
			else if(i==4) { mon = "April";}
			else if(i==5) { mon = "May";}
			else if(i==6) { mon = "June";}
			else if(i==7) { mon = "July";}
			else if(i==8) { mon = "August";}
			else if(i==9) { mon = "September";}
			else if(i==10) { mon = "October";}
			else if(i==11) { mon = "November";}
			else if(i==12) { mon = "December";}
			for (int j = d+1; j <= dayOfMonth; j++) {
				check = true;
				Date date = new Date(j, mon, event.getDate().getYear(), event.getDate().getInfo());
				Event e = new Event(date, time);
				myCalendar.add(e);
				db.insert(j, mon, event.getDate().getYear(), event.getTime().getHr(), event.getTime().getMin(), event.getDate().getInfo());
				
			}
			if(check == false) {
				d = 0;
			}
		}
		
	}
	/**
	 * repeat monthly that year only
	 * @param event
	 */
	public void addMonthly(Event event) {
		this.event = event;
		int d = event.getDate().getDay();
		int dayOfMonth =0;
		int m = 0;
		String mon = "";
		Time time = new Time(event.getTime().getHr(), event.getTime().getMin());
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
			m = 12;
		}
		for (int i = m+1; i <= 12; i++) {
			if(i==1) { 
				mon = "January";
				dayOfMonth = 31;
			}else if(i==2) { 
				mon = "February";
				dayOfMonth = 28;
			}else if(i==3) { 
				mon = "March";
				dayOfMonth = 31;
			}else if(i==4) { 
				mon = "April";
				dayOfMonth = 30;
			}else if(i==5) { 
				mon = "May";
				dayOfMonth = 31;
			}else if(i==6) { 
				mon = "June";
				dayOfMonth = 30;
			}else if(i==7) { 
				mon = "July";
				dayOfMonth = 31;
			}else if(i==8) { 
				mon = "August";
				dayOfMonth = 31;
			}else if(i==9) { 
				mon = "September";
				dayOfMonth = 30;
			}else if(i==10) { 
				mon = "October";
				dayOfMonth = 31;
			}else if(i==11) { 
				mon = "November";
				dayOfMonth = 30;
			}else if(i==12) { 
				mon = "December";
				dayOfMonth = 31;
			}
			
			if(d <= dayOfMonth) {
				Date date = new Date(d, mon, event.getDate().getYear(), event.getDate().getInfo());
				Event e = new Event(date, time);
				myCalendar.add(e);
				db.insert(d, mon, event.getDate().getYear(), event.getTime().getHr(), event.getTime().getMin(), event.getDate().getInfo());
			}
			
		}
		
	}
	/**
	 * repeat weekly that year only
	 * @param event
	 */
	public void addWeekly(Event event) {
		this.event = event;
		int d = event.getDate().getDay();
		int dayOfMonth =0;
		int m = 0;
		String mon = "";
		int lastday=0;
		boolean check = false;
		Time time = new Time(event.getTime().getHr(), event.getTime().getMin());
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
			m = 12;
		}
		for (int i = m; i <= 12; i++) {
			if(i==1) { mon = "January";}
			else if(i==2) { mon = "February";}
			else if(i==3) { mon = "March";}
			else if(i==4) { mon = "April";}
			else if(i==5) { mon = "May";}
			else if(i==6) { mon = "June";}
			else if(i==7) { mon = "July";}
			else if(i==8) { mon = "August";}
			else if(i==9) { mon = "September";}
			else if(i==10) { mon = "October";}
			else if(i==11) { mon = "November";}
			else if(i==12) { mon = "December";}
			int j = d+7;
			while (j <= dayOfMonth) {
				check = true;
				Date date = new Date(j, mon, event.getDate().getYear(), event.getDate().getInfo());
				Event e = new Event(date, time);
				addEvent(e);
				lastday = j;
				j+=7;
			}
			d = dayOfMonth-lastday;
		}

	}
	
	public void delDaily(Event event) {
		this.event = event;
		int d = event.getDate().getDay();
		int dayOfMonth =0;
		int m = 0;
		String mon = "";
		boolean check = false;
		Time time = new Time(event.getTime().getHr(), event.getTime().getMin());
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
			m = 12;
		}
		for (int i = 1; i <= 12; i++) {
			if(i==1) { mon = "January";}
			else if(i==2) { mon = "February";}
			else if(i==3) { mon = "March";}
			else if(i==4) { mon = "April";}
			else if(i==5) { mon = "May";}
			else if(i==6) { mon = "June";}
			else if(i==7) { mon = "July";}
			else if(i==8) { mon = "August";}
			else if(i==9) { mon = "September";}
			else if(i==10) { mon = "October";}
			else if(i==11) { mon = "November";}
			else if(i==12) { mon = "December";}
			for (int j = 1; j <= dayOfMonth; j++) {
				Date date = new Date(j, mon, event.getDate().getYear(), event.getDate().getInfo());
				Event e = new Event(date, time);
				delEvent(e);
			}
		}
		
	}
	public void delMonthly(Event event) {
		this.event = event;
		int d = event.getDate().getDay();
		int dayOfMonth =0;
		int m = 0;
		String mon = "";
		Time time = new Time(event.getTime().getHr(), event.getTime().getMin());
		if(event.getDate().getMonth().equals("January")) { 
			dayOfMonth = 31 ;
			m = 1;
		}else if(event.getDate().getMonth().equals("February")) { 
			dayOfMonth = 28 ;
			m = 2;
		}else if(event.getDate().getMonth().equals("March")) { 
			dayOfMonth = 31 ;
			m = 3;
		}else if(event.getDate().getMonth().equals("April")) { 
			dayOfMonth = 30 ;
			m = 4;
		}else if(event.getDate().getMonth().equals("May")) { 
			dayOfMonth = 31 ;
			m = 5;
		}else if(event.getDate().getMonth().equals("June")) { 
			dayOfMonth = 30 ;
			m = 6;
		}else if(event.getDate().getMonth().equals("July")) { 
			dayOfMonth = 31 ;
			m = 7;
		}else if(event.getDate().getMonth().equals("August")) { 
			dayOfMonth = 31 ;
			m = 8;
		}else if(event.getDate().getMonth().equals("September")) { 
			dayOfMonth = 30 ;
			m = 9;
		}else if(event.getDate().getMonth().equals("October")) { 
			dayOfMonth = 31 ;
			m = 10;
		}else if(event.getDate().getMonth().equals("November")) { 
			dayOfMonth = 30 ;
			m = 11;
		}else if(event.getDate().getMonth().equals("December")) { 
			dayOfMonth = 31 ;
			m = 12;
		}
		for (int i = 1; i <= 12; i++) {
			if(i==1) { 
				mon = "January";
				dayOfMonth = 31;
			}else if(i==2) { 
				mon = "February";
				dayOfMonth = 28;
			}else if(i==3) { 
				mon = "March";
				dayOfMonth = 31;
			}else if(i==4) { 
				mon = "April";
				dayOfMonth = 30;
			}else if(i==5) { 
				mon = "May";
				dayOfMonth = 31;
			}else if(i==6) { 
				mon = "June";
				dayOfMonth = 30;
			}else if(i==7) { 
				mon = "July";
				dayOfMonth = 31;
			}else if(i==8) { 
				mon = "August";
				dayOfMonth = 31;
			}else if(i==9) { 
				mon = "September";
				dayOfMonth = 30;
			}else if(i==10) { 
				mon = "October";
				dayOfMonth = 31;
			}else if(i==11) { 
				mon = "November";
				dayOfMonth = 30;
			}else if(i==12) { 
				mon = "December";
				dayOfMonth = 31;
			}
			if(d <= dayOfMonth) {
				Date date = new Date(d, mon, event.getDate().getYear(), event.getDate().getInfo());
				Event e = new Event(date, time);
				delEvent(e);
			}
			
		}
	}
	
	
	
	public String show(){
		return String.format("%s : %s  %s",event.getTime().getHr(), event.getTime().getMin(), event.getDate().getInfo());
	}
	
	public ArrayList<Event> getMyCalendar() {
		return myCalendar;
	}

	
}
