	/**
	 * Natchaneeya Srithanavanich 5810404987
	 */
package ku.cs.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import ku.cs.calendar.models.Event;
import ku.cs.calendar.controllers.DatabaseController;
import ku.cs.calendar.models.Calendar;
import ku.cs.calendar.models.Date;
import ku.cs.calendar.models.Time;

public class MyAppTest {

	@Test
	public void testAddEvent() {
		Calendar c = new Calendar();
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		c.addEvent(app);
		assertEquals((c.getMyCalendar().get(c.getMyCalendar().size()-1)),app);

	}
	@Test
	public void testDelEvent(){
		Calendar c = new Calendar();
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		int beforeAdd = c.getMyCalendar().size();
		c.addEvent(app);
		c.delEvent(app);
		int afterDel = c.getMyCalendar().size();
		assertEquals(beforeAdd, afterDel);
	}
	
	@Test
	public void testAddDatabase() {
		Calendar c = new Calendar();
		DatabaseController db = new DatabaseController();
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		c.addEvent(app);
		db.insert(11, "May", 1997, "04", "00", "My Birthday!");
		
	}

	
}
