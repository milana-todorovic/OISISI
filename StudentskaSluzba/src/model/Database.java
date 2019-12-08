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
			// TODO dodati provjeru da li vec postoji serijalizovan objekat i deserijalizaciju
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
		ArrayList<String> studenti = new ArrayList<String>();
		studenti.add("ra1-2017");
		studenti.add("ra2-2017");
		studenti.add("ra3-2017");
		studenti.add("ra4-2017");
		studenti.add("ra5-2017");
		studenti.add("ra6-2017");
		studenti.add("ra7-2017");
		studenti.add("ra8-2017");
		studenti.add("ra9-2017");
		studenti.add("ra10-2017");
		studenti.add("ra11-2017");
		studenti.add("ra12-2017");
		studenti.add("ra13-2017");
		studenti.add("ra14-2017");
		studenti.add("ra15-2017");
		studenti.add("ra16-2017");
		predmeti.add(new Predmet("E227A", "LPRS 1", 2, 3));
		predmeti.add(new Predmet("E216", "OET", 1, 2));
		predmeti.add(new Predmet("E225", "Operativni sistemi", 2, 4));
		predmeti.get(1).setStudenti(studenti);
	}

}
