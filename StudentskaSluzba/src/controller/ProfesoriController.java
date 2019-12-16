/**
 * 
 */
package controller;

import model.Database;
import model.Profesor;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriController {

	public int getBrojProfesora() {
		return Database.getInstance().getBrojProfesora();
	}

	public Profesor getProfesor(int index) {
		return Database.getInstance().getProfesor(index);
	}

}
