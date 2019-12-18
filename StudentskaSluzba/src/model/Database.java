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

	private List<Profesor> profesori;
	private List<Predmet> predmeti;
	private List<Student> studenti;

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

		this.profesori = new ArrayList<Profesor>();
		this.predmeti = new ArrayList<Predmet>();
		this.studenti = new ArrayList<Student>();
		this.predmetiMock();
		this.profesoriMock();
		this.studentiMock();
	}

	public int getBrojPredmeta() {
		return predmeti.size();
	}

	public Predmet getPredmet(int index) {
		return predmeti.get(index);
	}

	public void removePredmet(int index) {
		Predmet predmet = this.predmeti.get(index);
		for (Student student : predmet.getStudenti()) {
			student.getPredmeti().remove(predmet);
		}
		Profesor profesor = predmet.getProfesor();
		if (profesor != null) {
			profesor.getPredmeti().remove(predmet);
		}
		predmeti.remove(index);
	}

	public int getBrojProfesora() {
		return profesori.size();
	}

	public Profesor getProfesor(int index) {
		return profesori.get(index);
	}

	public int getBrojStudenata() {
		return studenti.size();
	}

	public Student getStudent(int index) {
		return studenti.get(index);
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
		predmeti.add(new Predmet("E223A", "Objektno programiranje", 2, 1));
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
		profesori.get(4).addPredmet(predmeti.get(8));
		predmeti.get(8).setProfesor(profesori.get(4));
	}

	private void studentiMock() {
		studenti.add(new Student("Marko", "Petrovic", LocalDate.of(1998, 3, 16), "Jovana Ducica 16", "0664125861",
				"markopetrovic@uns.ac.rs", "ra16-2017", LocalDate.of(2017, 7, 3), 3, Student.Status.B, 9.06));
		studenti.add(new Student("Vasilije", "Butulija", LocalDate.of(1997, 4, 2), "Salvadora Aljendea 10",
				"0654443322", "vasilijebutulija@uns.ac.rs", "ra140-2016", LocalDate.of(2016, 7, 5), 4, Student.Status.S,
				7.55));
		studenti.add(new Student("Viktorija", "Radojcic", LocalDate.of(1998, 8, 12), "Mihajla Pupina 21", "0661112202",
				"vikiradojcic@uns.ac.rs", "ra12-2017", LocalDate.of(2017, 7, 1), 3, Student.Status.B, 10.00));
		studenti.add(new Student("Iva", "Aleksic", LocalDate.of(1995, 7, 24), "Milutina Milankovica 18", "0656561221",
				"ivaaleksic@uns.ac.rs", "ra186-2016", LocalDate.of(2016, 7, 2), 4, Student.Status.S, 8.88));
		studenti.add(new Student("Milan", "Jovic", LocalDate.of(1997, 5, 5), "Desanke Maksimovic 14", "0654478998",
				"milanjovic@uns.ac.rs", "ee200-2016", LocalDate.of(2016, 7, 5), 4, Student.Status.B, 6.67));
		studenti.add(new Student("Helena", "Govedarica", LocalDate.of(1994, 10, 28), "Jovana Ducica 25", "0654011100",
				"helenagov@uns.ac.rs", "ee14-2015", LocalDate.of(2015, 7, 1), 4, Student.Status.S, 8.04));
		ArrayList<Student> studenti1 = new ArrayList<Student>();
		studenti1.add(studenti.get(1));
		studenti1.add(studenti.get(3));
		studenti1.add(studenti.get(4));
		predmeti.get(3).setStudenti(studenti1);
		predmeti.get(0).setStudenti(studenti1);
		for (Student student : studenti1) {
			student.addPredmet(predmeti.get(3));
			student.addPredmet(predmeti.get(0));
		}
		predmeti.get(5).setStudenti(studenti);
		for (Student student : studenti) {
			student.addPredmet(predmeti.get(5));
		}
	}

}
