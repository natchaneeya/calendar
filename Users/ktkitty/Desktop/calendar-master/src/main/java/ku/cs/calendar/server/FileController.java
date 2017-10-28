package ku.cs.calendar.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import ku.cs.calendar.common.DataSource;
import ku.cs.calendar.common.Date;
import ku.cs.calendar.common.Event;
import ku.cs.calendar.common.Time;

public class FileController implements DataSource{
	private String filename;

    public FileController(String filename) {
        this.filename = filename;
    }

    private ObjectInputStream createInputStream() {
        try {
            return new ObjectInputStream(new FileInputStream(filename));
        } catch (Exception e) {
            return null;
        }
    }

    private ObjectOutputStream createOutputStream(boolean append) {
        try {
            return new ObjectOutputStream(new FileOutputStream(filename, append));
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Event> select() {
        ArrayList<Event> events = new ArrayList<Event>();
        ObjectInputStream in = createInputStream();
        if (in != null) {
            try {
                while (true) {
                    try {
                    	Event event = (Event) in.readObject();
                        events.add(event);
                    } catch (EOFException e) {
                        break;
                    }
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return events;
    }
	
	
	@Override
	public void insert(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO) {
		Date date = new Date(DAY, MONTH, YEAR, INFO);
		Time time = new Time(HR, MIN);
		Event e = new Event(date, time);
		ArrayList<Event> events = select();
	    ObjectOutputStream in = createOutputStream(false);
	    	if (in != null) {
	    		try {
	            	if (events.size() == 0) {
	                    e.setId(1);
	                } else {
	                    e.setId(events.get(events.size() -  1).getId() + 1);
	                }
	                events.add(e);
	                for (Event event: events) {
	                    in.writeObject(event);
	                }
	                in.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }

	        }

		
	}

	@Override
	public void delete(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO) {
		ArrayList<Event> events = select();
		Date date = new Date(DAY, MONTH, YEAR, INFO);
		Time time = new Time(HR, MIN);
		Event e = new Event(date, time);
        ObjectOutputStream in = createOutputStream(false);
        if (in != null) {
            try {
                for (Event event: events) {
                    if (event.getId() != e.getId()) {
                        in.writeObject(event);
                    }
                }
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    
	}

	@Override
	public void update(int DAY, String MONTH, int YEAR, String HR, String MIN, String INFO) {
		Date date = new Date(DAY, MONTH, YEAR, INFO);
		Time time = new Time(HR, MIN);
		Event e = new Event(date, time);
		ArrayList<Event> events = select();
        ObjectOutputStream in = createOutputStream(false);
        if (in != null) {
            try {
                for (Event event: events) {
                    if (event.getId() == e.getId()) {
                        in.writeObject(e);
                    } else {
                        in.writeObject(event);
                    }
                }
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
		
	}
	
}
