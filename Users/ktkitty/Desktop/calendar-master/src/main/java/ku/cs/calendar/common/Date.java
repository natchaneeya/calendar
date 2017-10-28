package ku.cs.calendar.common;

import java.io.Serializable;

/**
 * Natchaneeya Srithanavanich 5810404987
 */

public class Date  implements Serializable{
	private int day;
	private String month;
	private int year;
	private String info;

	public Date(int day, String month, int year, String info) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.info = info;
	}
	public int getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	} 
	public String getInfo() {
		return info;
	}
	
	

}
