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
		predmeti.add(new Predmet("E227A", "LPRS 1", 2, 3));
		predmeti.add(new Predmet("E216", "OET", 1, 2));
		predmeti.add(new Predmet("E225", "Operativni sistemi", 2, 4));
		predmeti.add(new Predmet("E217", "Arhitektura racunara", 1, 2));
		predmeti.add(new Predmet("E214", "PJiSP", 1, 1));
		predmeti.add(new Predmet("EJ1Z", "Engleski jezik - osnovni", 1, 1));
		predmeti.add(new Predmet("E212", "Matematicka analiza 1", 1, 1));
		predmeti.add(new Predmet("E213A", "Algebra", 1, 1));
		predmeti.add(new Predmet("E214", "PJiSP", 1, 1));
		predmeti.add(new Predmet("E223A", "Objektno programiranje", 2, 1));
		predmeti.get(1).addStudent("ra1-2017");
		predmeti.get(1).addStudent("ra3-2017");
		predmeti.get(1).addStudent("ra36-2017");
		predmeti.get(1).addStudent("ra186-2017");
		predmeti.get(0).addStudent("ra5-2017");
		predmeti.get(0).addStudent("ra36-2017");
		predmeti.get(0).addStudent("ra15-2017");
		predmeti.get(2).addStudent("ra125-2017");
		predmeti.get(5).addStudent("ra31-2017");
		predmeti.get(5).addStudent("ra136-2017");
		predmeti.get(5).addStudent("ra16-2017");
		predmeti.get(6).addStudent("ra5-2017");
		predmeti.get(8).addStudent("ra1-2017");
		predmeti.get(8).addStudent("ra3-2017");
		predmeti.get(8).addStudent("ra36-2017");
		predmeti.get(8).addStudent("ra186-2017");
	}

	private void profesoriMock() {
		profesori.add(new Profesor("Dragan", "Kasikovic", LocalDate.of(1971, 5, 1), "Milosa Obilica 14", "066437227",
				"kasikovic@uns.ac.rs", "Trg Dositeja Obradovica 6", "4960945", "titula", "zvanje"));
		profesori.add(new Profesor("Ljubica", "Pantelic", LocalDate.of(1980, 10, 14), "Cara Lazara 37", "0614311227",
				"ljubica@uns.ac.rs", "Trg Dositeja Obradovica 6", "1190000", "titula", "zvanje"));
		profesori.add(new Profesor("Mihajlo", "Golub", LocalDate.of(1988, 2, 29), "Kosovska 7", "0631111227",
				"golub@uns.ac.rs", "Trg Dositeja Obradovica 6", "1195550", "titula", "zvanje"));
		profesori.add(new Profesor("Marko", "Maksimovic", LocalDate.of(1988, 2, 29), "Kisacka 7", "0631555227",
				"marko@uns.ac.rs", "Trg Dositeja Obradovica 6", "6695550", "titula", "zvanje"));
		profesori.add(new Profesor("Milica", "Todorovic", LocalDate.of(1988, 2, 29), "Marka Miljanova 7", "0601322175",
				"milicatodorovic@uns.ac.rs", "Trg Dositeja Obradovica 6", "6666666", "titula", "zvanje"));
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
		profesori.get(4).addPredmet(predmeti.get(9));
		predmeti.get(9).setProfesor(profesori.get(4));
	}

}
