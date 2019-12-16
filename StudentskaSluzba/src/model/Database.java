/**
 * 
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
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
	private List<Profesor> profesori;
	private List<Predmet> predmeti;

	/**
	 * @return the instance
	 */
	public static Database getInstance() {
		if (instance == null)
			// TODO dodati provjeru da li vec postoji serijalizovan objekat i
			// deserijalizaciju
			instance = new Database();

		return instance;
	}

	private Database() {
		// TODO instancirati listu studenata kada bude implementirana funkcionalnost
		// #student
		this.profesori = new ArrayList<Profesor>();
		this.predmeti = new ArrayList<Predmet>();
		this.predmetiMock();
		this.profesoriMock();
	}

	public int getBrojPredmeta() {
		return predmeti.size();
	}

	public Predmet getPredmet(int index) {
		return predmeti.get(index);
	}

	public int getBrojProfesora() {
		return profesori.size();
	}

	public Profesor getProfesor(int index) {
		return profesori.get(index);
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

	private void profesoriMock() {
		profesori.add(new Profesor("Dragan", "Kasikovic", LocalDate.of(1971, 5, 1), "Milosa Obilica 14", "066437227",
				"kasikovic@uns.ac.rs", "Trg Dositeja Obradovica 6", "4960945", "titula", "zvanje"));
		profesori.add(new Profesor("Ljubica", "Pantelic", LocalDate.of(1980, 10, 14), "Cara Lazara 37", "0614311227",
				"ljubica@uns.ac.rs", "Trg Dositeja Obradovica 6", "1190000", "titula", "zvanje"));
		profesori.add(new Profesor("Mihajlo", "Golub", LocalDate.of(1988, 2, 29), "Marka Miljanova 7", "0631111227",
				"golub@uns.ac.rs", "Trg Dositeja Obradovica 6", "1195550", "titula", "zvanje"));
		ArrayList<Predmet> pred1 = new ArrayList<Predmet>();
		pred1.add(this.predmeti.get(1));
		this.profesori.get(0).setPredmeti(pred1);
		for (Predmet predmet : pred1) {
			predmet.setProfesor(profesori.get(0));
		}
		ArrayList<Predmet> pred2 = new ArrayList<Predmet>();
		pred2.add(this.predmeti.get(0));
		pred2.add(this.predmeti.get(2));
		this.profesori.get(2).setPredmeti(pred2);
		for (Predmet predmet : pred2) {
			predmet.setProfesor(profesori.get(2));
		}
	}

}
