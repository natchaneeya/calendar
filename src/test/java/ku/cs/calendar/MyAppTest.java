	/**
	 * Natchaneeya Srithanavanich 5810404987
	 */
package ku.cs.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import ku.cs.calendar.models.Event;
import ku.cs.calendar.models.Calendar;
import ku.cs.calendar.models.Date;
import ku.cs.calendar.models.Time;

public class MyAppTest {

	@Test
	public void testAddAppointment() {
		Calendar c = new Calendar();
		Date d = new Date(11, "May", 1997, "My Birthday!");
		Time t = new Time("04", "00");
		Event app = new Event(d, t);
		c.addAppointment(app);

		assertEquals((c.getMyCalendar().get(c.getMyCalendar().size()-1)),app);

	}

}
