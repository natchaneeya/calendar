	/**
	 * Natchaneeya Srithanavanich 5810404987
	 */
package ku.cs.calendar;

import static org.junit.Assert.*;


import org.junit.Test;

import ku.cs.calendar.common.Calendar;
import ku.cs.calendar.common.DataSource;
import ku.cs.calendar.common.Date;
import ku.cs.calendar.common.Event;
import ku.cs.calendar.common.Time;
import ku.cs.calendar.server.DatabaseController;
import ku.cs.calendar.server.FileController;

public class MyAppTest {

	@Test
	public void testAddEvent() {
		Calendar c = new Calendar();
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		c.addEvent(app,"Not repeat");
		assertEquals((c.getMyCalendar().get(c.getMyCalendar().size()-1)),app);

	}
//	@Test
//	public void testDelEvent(){
//		Calendar c = new Calendar();
//		Date d = new Date(11, "May", 1997, "My Birthday!");
//		Time t = new Time("04", "00");
//		Event app = new Event(d, t);
//		int beforeAdd = c.getMyCalendar().size();
//		System.out.println(beforeAdd);
//		c.addEvent(app,"Not repeat");
//		c.delEvent(app,"Not repeat");
//		
//		int afterDel = c.getMyCalendar().size();
//		System.out.println(afterDel);
//		assertEquals(beforeAdd, afterDel);
//	}
	
	@Test
	public void testAddDatabase() {
		Calendar c = new Calendar();
		DataSource dataSource = new FileController("text.txt");
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		c.addEvent(app, "Not repeat");
		dataSource.insert(11, "May", 1997, "04", "00", "My Birthday!");
		
	}

	
}
