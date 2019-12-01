/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Database implements Serializable {

	private static final long serialVersionUID = 1857113152292828485L;

	private static Database instance;
	// TODO dodati listu studentata kada bude implementirana funkcionalnost #student
	// TODO dodati listu profesora kada bude implementirana funkcionalnost #profesor
	private List<Predmet> predmeti;

	/**
	 * @return the instance
	 */
	public static Database getInstance() {
		if (instance == null)
			instance = new Database();

		return instance;
	}

	private Database() {
		this.predmeti = new ArrayList<Predmet>();
		this.predmetiMock();
	}

	public int getBrojPredmeta() {
		return predmeti.size();
	}

	public Predmet getPredmet(int index) {
		return predmeti.get(index);
	}

	private void predmetiMock() {
		predmeti.add(new Predmet("E227A", "LPRS 1", 2, 3));
		predmeti.add(new Predmet("E216", "OET", 1, 2));
		predmeti.add(new Predmet("E225", "Operativni sistemi", 2, 4));
	}

}
