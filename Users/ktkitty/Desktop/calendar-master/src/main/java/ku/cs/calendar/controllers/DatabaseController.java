/**
 * Natchaneeya Srithanavanich 5810404987
 */
package ku.cs.calendar.controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ku.cs.calendar.models.DataSource;
import ku.cs.calendar.models.Date;
import ku.cs.calendar.models.Event;
import ku.cs.calendar.models.Time;

public class DatabaseController implements DataSource{
	public DatabaseController() {
	
	}

	public void setUp() {
		try {
			// setUp
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database...");
				// display database infomation
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Product name: " + dm.getDatabaseProductName());

//				// execute SQL statements
				System.out.println("-----Data in event-----");

				String query = "Select * from event";
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					int day = resultSet.getInt(2);
					String month = resultSet.getString(3);
					int year = resultSet.getInt(4);
					String hr = resultSet.getString(5);
					String min = resultSet.getString(6);
					String info = resultSet.getString(7);

					System.out.println("ID:  "+ id + " Day: " + day + " Month: " + month + " Year: " + year + " Time: "
							+ hr + ":" + min + " ->Information: " + info);
				}
				// close connection
				conn.close();
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	public void createDatabase() {
        try {
        	Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
            Connection conn = DriverManager.getConnection(dbURL);
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "Appointments", null);
            boolean appointmentsTableExist = false;
            while (rs.next()) {
                if ("Appointments".equals(rs.getString(3))) appointmentsTableExist = true;
            }
            if (!appointmentsTableExist) {
                String query = "CREATE TABLE \"event\" ( `id` INTEGER PRIMARY KEY AUTO_INCREMENT, `day` INTEGER , `month` TEXT, `year` INT , `hr` TEXT , `min` TEXT `info` TEXT)";
                Statement statement = conn.createStatement();
                statement.execute(query);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
	


	public void insert(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO) {
		try {
			// setUp
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				String query = String.format(
						"Insert into event(day,month,year,hr,min,info) values(%d,'%s',%d,'%s','%s','%s') ", DAY, MONTH,
						YEAR, HR, MIN, INFO);
				Statement statement = conn.createStatement();
				statement.execute(query);
				
				Date date = new Date(DAY, MONTH, YEAR, INFO);
				Time time = new Time(HR, MIN);
				Event e = new Event(date, time);
	            query = "SELECT max(ID) FROM event";
	            ResultSet resultSet = statement.executeQuery(query);
	            resultSet.next();
	            int id = resultSet.getInt(1);
	            e.setId(id);

				conn.close();
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		select();

	}

	public void delete(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO) {
		try {
			// setUp
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				// display database infomation
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

				String query = String.format(
						"Delete from event where day = %d and month = '%s' and year = %d and hr= '%s' and min='%s' and info='%s'",
						DAY, MONTH, YEAR, HR, MIN, INFO);
				Statement statement = conn.createStatement();
				statement.execute(query);

			}
			// close connection
			conn.close();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		select();

	}

	public ArrayList<Event> select() {
		ArrayList<Event> events = new ArrayList<>();
		try {
			//setUp
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if(conn != null) {
				System.out.println("in database ....");
//				System.out.println("Connected to the database...");
				//display database infomation
				DatabaseMetaData dm = (DatabaseMetaData)conn.getMetaData();
//				System.out.println("Driver name: " + dm.getDriverName());
//				System.out.println("Product name: " + dm.getDatabaseProductName());
				
				//execute SQL statements
//				System.out.println("-----Data in event-----");
				
				String query = "Select * from event";
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				String ans="";
				
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					int day = resultSet.getInt(2);
					String month = resultSet.getString(3);
					int year = resultSet.getInt(4);
					String hr = resultSet.getString(5);
					String min = resultSet.getString(6);
					String info = resultSet.getString(7);
					
					Date d = new Date(day, month, year, info);
					Time t = new Time(hr, min);
					Event e = new Event(d, t);
					events.add(e);
					System.out.println("ID:  "+ id + " Day: " + day + " Month: " + month + " Year: " + year + " Time: "
							+ hr + ":" + min + " ->Information: " + info);
					

				}
				conn.close();
			return events;
		
			
			}	
			
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return events;
		
		
	}
	
	public void update(int DAY,String MONTH, int YEAR, String HR, String MIN ,String INFO) {
		
		try {
			// setUp
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:event.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database...");
				// display database infomation
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Product name: " + dm.getDatabaseProductName());

				// execute SQL statements
				System.out.println("-----Data in event-----");

				String query = String.format(
						"UPDATE event SET day=%d , month='%s' , year=%d , hr='%s' , min='%s', info='%s' where id = %d ",
						DAY, MONTH, YEAR, HR, MIN, INFO);
				Statement statement = conn.createStatement();
				statement.execute(query);

			}
			// close connection
			conn.close();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	

}
