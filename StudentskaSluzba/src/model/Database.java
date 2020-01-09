/**
 * 
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Milana Todorovic ra3-2017
 * @author Ana Perisic ra1-2017
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

	/**
	 * @return broj predmeta u bazi
	 */
	public int getBrojPredmeta() {
		return predmeti.size();
	}

	/**
	 * @param index
	 * @return predmet na prosledjenom indeksu
	 */
	public Predmet getPredmet(int index) {
		return predmeti.get(index);
	}

	/**
	 * @param sifra
	 * @return predmet sa prosledjenom sifrom
	 */
	public Predmet findPredmetById(String sifra) {
		int index = predmeti.indexOf(new Predmet(sifra, "", 0, 0));
		return (index == -1) ? null : predmeti.get(index);
	}

	/**
	 * Metoda koja brise predmet na prosledjenom indeksu i sve njegove veze sa
	 * drugim etitetima u bazi.
	 * 
	 * @param index
	 */
	public void removePredmet(int index) {
		Predmet predmet = this.predmeti.get(index);
		for (Student student : predmet.getStudenti()) {
			student.getPredmeti().remove(predmet);
		}
		Profesor profesor = predmet.getProfesor();
		if (profesor != null) {
			profesor.getPredmeti().remove(predmet);
		}
		this.predmeti.remove(index);
	}

	/**
	 * @return broj profesora u bazi
	 */
	public int getBrojProfesora() {
		return profesori.size();
	}

	/**
	 * @param index
	 * @return profesor na prosledjenom indeksu
	 */
	public Profesor getProfesor(int index) {
		return profesori.get(index);
	}

	/**
	 * Metoda koja brise profesora na prosledjenom indeksu i sve njegove veze sa
	 * drugim etitetima u bazi.
	 * 
	 * @param index
	 */
	public void removeProfesor(int index) {
		Profesor profesor = this.profesori.get(index);
		for (Predmet predmet : profesor.getPredmeti()) {
			predmet.setProfesor(null);
		}
		this.profesori.remove(index);
	}

	public int getBrojStudenata() {
		return studenti.size();
	}

	public Student getStudent(int index) {
		return studenti.get(index);
	}

	public void removeStudent(int index) {
		Student student = this.studenti.get(index);
		for (Predmet predmet : student.getPredmeti()) {
			predmet.getStudenti().remove(student);
		}
		this.studenti.remove(index);
	}

	public void removeStudentPredmet(int studentIndex, int predmetIndex) {
		Student student = this.studenti.get(studentIndex);
		Predmet predmet = student.getPredmeti().get(predmetIndex);

		student.getPredmeti().remove(predmet);
		predmet.getStudenti().remove(student);
	}

	public void removePredmetStudent(int predmetIndex, int studentIndex) {
		Predmet predmet = this.predmeti.get(predmetIndex);
		Student student = predmet.getStudenti().get(studentIndex);

		predmet.getStudenti().remove(student);
		student.getPredmeti().remove(predmet);
	}

	private void predmetiMock() {
		predmeti.add(new Predmet("E227A", "LPRS 1", 2, 1));
		predmeti.add(new Predmet("E216", "OET", 1, 2));
		predmeti.add(new Predmet("E225", "Operativni sistemi", 2, 2));
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
				"markopetrovic@uns.ac.rs", "ra16-2017", LocalDate.of(2017, 7, 3), 1, Student.Status.B, 9.06));
		studenti.add(new Student("Vasilije", "Butulija", LocalDate.of(1997, 4, 2), "Salvadora Aljendea 10",
				"0654443322", "vasilijebutulija@uns.ac.rs", "ra140-2016", LocalDate.of(2016, 7, 5), 1, Student.Status.S,
				7.55));
		studenti.add(new Student("Viktorija", "Radojcic", LocalDate.of(1998, 3, 18), "Mihajla Pupina 21", "0661112202",
				"vikiradojcic@uns.ac.rs", "ra12-2017", LocalDate.of(2017, 7, 1), 1, Student.Status.B, 10.00));
		studenti.add(new Student("Iva", "Aleksic", LocalDate.of(1995, 7, 24), "Milutina Milankovica 18", "0656561221",
				"ivaaleksic@uns.ac.rs", "ra186-2016", LocalDate.of(2016, 7, 2), 1, Student.Status.S, 8.88));
		studenti.add(new Student("Milan", "Jovic", LocalDate.of(1997, 5, 5), "Desanke Maksimovic 14", "0654478998",
				"milanjovic@uns.ac.rs", "ee200-2016", LocalDate.of(2016, 7, 5), 1, Student.Status.B, 6.67));
		studenti.add(new Student("Helena", "Govedarica", LocalDate.of(1994, 10, 28), "Jovana Ducica 25", "0654011100",
				"helenagov@uns.ac.rs", "ee14-2015", LocalDate.of(2015, 7, 1), 1, Student.Status.S, 8.04));
		ArrayList<Student> studenti1 = new ArrayList<Student>();
		studenti1.add(studenti.get(1));
		studenti1.add(studenti.get(3));
		studenti1.add(studenti.get(4));
		predmeti.get(3).setStudenti(studenti1);
		predmeti.get(1).setStudenti(studenti1);
		for (Student student : studenti1) {
			student.addPredmet(predmeti.get(3));
			student.addPredmet(predmeti.get(1));
		}
		predmeti.get(5).setStudenti(new ArrayList<Student>(studenti));
		for (Student student : studenti) {
			student.addPredmet(predmeti.get(5));
		}
	}

	/**
	 * Metoda koja brise vezu izmedju profesora i predmeta.
	 * 
	 * @param profesorIndex - indeks profesora u bazi
	 * @param predmetIndex  - indeks predmeta u listi predmeta zadatog profesora
	 */
	public void removeProfesorPredmet(int profesorIndex, int predmetIndex) {
		Profesor profesor = this.profesori.get(profesorIndex);
		Predmet predmet = profesor.getPredmeti().get(predmetIndex);
		predmet.setProfesor(null);
		profesor.getPredmeti().remove(predmetIndex);
	}

	/**
	 * Metoda koja brise vezu izmedju profesora i predmeta.
	 * 
	 * @param predmetIndex - indeks predmeta u bazi
	 */
	public void removePredmetProfesor(int predmetIndex) {
		Predmet predmet = this.predmeti.get(predmetIndex);
		predmet.getProfesor().getPredmeti().remove(predmet);
		predmet.setProfesor(null);
	}

	/**
	 * @param indeksPredmeta
	 * @return indeks u bazi profesora koji predaje zadati predmet
	 */
	public int indeksProfesoraNaPredmetu(int indeksPredmeta) {
		Predmet predmet = this.predmeti.get(indeksPredmeta);
		if (predmet.getProfesor() == null)
			return -1;
		else
			return this.profesori.indexOf(predmet.getProfesor());
	}

	/**
	 * Metoda koja dodaje predmet u bazu.
	 * 
	 * @param values
	 * @return indikator uspesnosti
	 */
	public boolean addPredmet(Map<String, Object> values) {
		for (String key : Predmet.keys) {
			if (!values.containsKey(key))
				return false;
		}
		predmeti.add(new Predmet(values));
		return true;
	}

	/**
	 * Metoda koja azurira predmet na prosledjenom indeksu.
	 * 
	 * @param index
	 * @param values
	 */
	public void updatePredmet(int index, Map<String, Object> values) {
		predmeti.get(index).set(values);
	}

	/**
	 * Metoda koja kreira vezu izmedju zadatog profesora i predmeta.
	 * 
	 * @param profesorIndex - indeks profesora u bazi
	 * @param predmetIndex  - indeks predmeta u bazi
	 */
	public void izmeniProfesoraNaPredmetu(int profesorIndex, int predmetIndex) {
		Predmet predmet = predmeti.get(predmetIndex);
		Profesor profesor = profesori.get(profesorIndex);
		if (predmet.getProfesor() != null) {
			predmet.getProfesor().getPredmeti().remove(predmet);
		}
		predmet.setProfesor(profesor);
		profesor.addPredmet(predmet);
	}

	public boolean addStudent(Map<String, Object> values) {
		for (String key : Student.keys) {
			if (!values.containsKey(key))
				return false;
		}
		studenti.add(new Student(values));
		return true;
	}

	public void updateStudent(int index, Map<String, Object> values) {
		studenti.get(index).set(values);
	}

	public Student findStudentByInd(String brIndeksa) {
		int index = -1;
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrIndeksa().toUpperCase().equals(brIndeksa)) {
				index = i;
				break;
			}
		}
		return (index == -1) ? null : studenti.get(index);
	}

}
