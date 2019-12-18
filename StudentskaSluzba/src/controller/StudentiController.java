/**
 * 
 */
package controller;

import model.Database;
import model.Student;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiController {

	public int getBrojStudenata() {
		return Database.getInstance().getBrojStudenata();
	}

	public Student getStudent(int index) {
		return Database.getInstance().getStudent(index);
	}

}
