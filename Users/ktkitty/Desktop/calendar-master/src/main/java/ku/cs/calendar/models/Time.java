package ku.cs.calendar.models;

import java.io.Serializable;

/**
 * Natchaneeya Srithanavanich 5810404987
 */
public class Time implements Serializable{
	private String hr;
	private String min;
	
	public Time(String hr, String min) {
		this.hr = hr;
		this.min = min;
	}
	public String getHr() {
		return hr;
	}
	public String getMin() {
		return min;
	}
	
	

}
