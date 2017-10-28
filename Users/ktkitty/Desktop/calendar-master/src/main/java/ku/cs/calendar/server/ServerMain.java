package ku.cs.calendar.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {

	public static void main(String[] args) {
		ApplicationContext bf = new ClassPathXmlApplicationContext("calendar-server.xml");

		System.out.println("Server is ready.");

	}

}
