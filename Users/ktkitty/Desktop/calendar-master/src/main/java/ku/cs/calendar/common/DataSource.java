/**
 * Natchaneeya Srithanavanich 5810404987
 */
package ku.cs.calendar.common;

import java.util.ArrayList;

public interface DataSource {
	void insert(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO);
	void delete(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO);
	ArrayList<Event> select();
	void update(int DAY,String MONTH, int YEAR, String HR, String MIN ,String INFO);
	
	
	

}
