/**
 * 
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import serialization_util.Serializator;

/**
 * @author Milana Todorovic ra3-2017
 * @author Ana Perisic ra1-2017
 *
 */
public class Database implements Serializable {

	private static final long serialVersionUID = 1857113152292828485L;

	private static String databaseSaveFile = "resource" + System.getProperty("file.separator") + "database.txt";
	private static Database instance;

	private List<Profesor> profesori;
	private List<Predmet> predmeti;
	private List<Student> studenti;

	/**
	 * @return the instance
	 */
	public static Database getInstance() {
		if (instance == null)
			try {
				instance = (Database) Serializator.deserialize(databaseSaveFile);
			} catch (Exception e) {
				instance = new Database();
			}

		return instance;
	}

	private Database() {
		this.profesori = new ArrayList<Profesor>();
		this.predmeti = new ArrayList<Predmet>();
		this.studenti = new ArrayList<Student>();

		this.studentiMock();
		this.profesoriMock();
		this.predmetiMock();
		this.studentiPredmetiMock();
	}

	public boolean saveState() {
		try {
			Serializator.serialize(databaseSaveFile, this);
			return true;
		} catch (Exception e) {
			return false;
		}
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

	public boolean addProfesor(Map<String, Object> values) {
		for (String key : Profesor.keys) {
			if (!values.containsKey(key))
				return false;
		}
		profesori.add(new Profesor(values));
		return true;
	}

	public Profesor findProfesorByLicna(String brLicneKarte) {
		int index = -1;
		for (int i = 0; i < profesori.size(); i++) {
			if (profesori.get(i).getBrojLicneKarte().equals(brLicneKarte)) {
				index = i;
				break;
			}
		}
		return (index == -1) ? null : profesori.get(index);
	}

	public void updateProfesor(int index, Map<String, Object> values) {
		profesori.get(index).set(values);
	}

	public void dodajStudentaNaPredmet(int studentIndex, int predmetIndex) {
		Predmet predmet = predmeti.get(predmetIndex);
		Student student = studenti.get(studentIndex);

		predmet.getStudenti().add(student);
		student.getPredmeti().add(predmet);
	}

	private void predmetiMock() {
		Predmet predmet = null;
		Profesor profesor = null;
		predmet = new Predmet("OP301", "Osnove programiranja", 1, 1);
		predmeti.add(predmet);
		profesor = findProfesorByLicna("007198721");
		profesor.addPredmet(predmet);
		predmet.setProfesor(profesor);
		predmet = new Predmet("DM881", "Diskretna matematika", 2, 3);
		predmeti.add(predmet);
		profesor = findProfesorByLicna("008431903");
		profesor.addPredmet(predmet);
		predmet.setProfesor(profesor);
		predmet = new Predmet("PP007", "Paralelno programiranje", 3, 5);
		predmeti.add(predmet);
		profesor = findProfesorByLicna("005671007");
		profesor.addPredmet(predmet);
		predmet.setProfesor(profesor);
		predmet = new Predmet("RVP33", "Ra\u010dunarstvo visokih performansi", 4, 7);
		predmeti.add(predmet);
		profesor = findProfesorByLicna("009999331");
		profesor.addPredmet(predmet);
		predmet.setProfesor(profesor);
		predmet = new Predmet("JSD91", "Jezici specifi\u010dni za domen", 4, 8);
		predmeti.add(predmet);
	}

	private void profesoriMock() {
		profesori.add(new Profesor("Aleksa", "Petkovi\u0107",
				LocalDate.parse("15.01.1965.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Temerinska 15, Novi Sad",
				"021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, MI 105",
				"007198721", "Prof. dr", "Redovni profesor"));
		profesori.add(new Profesor("Jana", "Lazarevi\u0107",
				LocalDate.parse("25.02.1963.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Jovana Cviji\u0107a 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com",
				"Dositeja Obradovi\u0107a 6, Novi Sad, Nastavni blok 206", "008431903", "Prof. dr",
				"Redovni profesor"));
		profesori.add(new Profesor("Na\u0111a", "Aleksi\u0107",
				LocalDate.parse("23.03.1973.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Gunduli\u0107eva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com",
				"Dositeja Obradovi\u0107a 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor"));
		profesori.add(new Profesor("\u0110or\u0111e", "Spasojevi\u0107",
				LocalDate.parse("24.08.1978.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"\u0160ekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com",
				"Dositeja Obradovi\u0107a 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor"));
		profesori.add(new Profesor("Elena", "Milenkovi\u0107",
				LocalDate.parse("08.11.1985.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Tolstojeva 52, Novi Sad",
				"021/834-901", "elena.milenkovic@mailinator.com",
				"Dositeja Obradovi\u0107a 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent"));
		profesori.add(new Profesor("Teodor", "Mladenovi\u0107",
				LocalDate.parse("14.12.1983.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Jovana Suboti\u0107a 33, Novi Sad", "021/441-007", "teodor.mladenovic@mailinator.com",
				"Dositeja Obradovi\u0107a 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent"));
	}

	private void studentiMock() {
		studenti.add(new Student("Luka", "Jovanovi\u0107",
				LocalDate.parse("01.01.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Kara\u0111or\u0111eva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA 1/2019",
				LocalDate.parse("01.07.2019.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 1, Student.Status.B, 8.32));
		studenti.add(new Student("Sofija", "Petrovi\u0107",
				LocalDate.parse("16.05.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Milo\u0161a Pocerca 55, \u0160abac", "015/343-356", "sofija.petrovic@mailinator.com", "RA 5/2019",
				LocalDate.parse("11.07.2019.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 1, Student.Status.B, 8.99));
		studenti.add(new Student("Stefan", "Nikoli\u0107",
				LocalDate.parse("18.03.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Knez Mihajlova 16, Beograd", "011/9234-857", "stefan.nikolic@mailinator.com", "RA 3/2019",
				LocalDate.parse("03.07.2019.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 1, Student.Status.B, 8.57));
		studenti.add(new Student("Dunja", "Ili\u0107",
				LocalDate.parse("11.11.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Petefi \u0160andora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", "RA 2/2019",
				LocalDate.parse("01.07.2019.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 1, Student.Status.S, 7.05));
		studenti.add(new Student("Lazar", "\u0110or\u0111evi\u0107",
				LocalDate.parse("03.12.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Josip Broz Tito 13, Subotica", "024/333-559", "lazar.djordjevic@mailinator.com", "RA 4/2019",
				LocalDate.parse("06.07.2019.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 1, Student.Status.S, 6.84));
		studenti.add(new Student("Sara", "Pavlovi\u0107",
				LocalDate.parse("03.12.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Vojvode Mi\u0161i\u0107a 23, \u0160abac", "015/313-061", "sara.pavlovic@mailinator.com", "RA 3/2018",
				LocalDate.parse("01.07.2018.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 2, Student.Status.B, 9.60));
		studenti.add(new Student("Vuk", "Markovi\u0107",
				LocalDate.parse("03.12.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Temerinska 133, Novi Sad",
				"021/351-091", "vuk.markovic@mailinator.com", "RA 15/2018",
				LocalDate.parse("11.07.2018.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 2, Student.Status.B, 9.60));
		studenti.add(new Student("Teodora", "Popovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Surepova 15, \u0160abac",
				"015/324-500", "teodora.popovic@mailinator.com", "RA 133/2017",
				LocalDate.parse("03.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 2, Student.Status.S, 7.64));
		studenti.add(new Student("Filip", "Stojanovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Francuska 113, Beograd",
				"011/2333-900", "filip.stojanovic@mailinator.com", "RA 122/2017",
				LocalDate.parse("02.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 2, Student.Status.S, 9.98));
		studenti.add(new Student("Ana", "\u017Divkovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Kralja Petra 20, Novi Sad",
				"021/231-114", "ana.zivkovic@mailinator.com", "RA 201/2017",
				LocalDate.parse("04.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 2, Student.Status.S, 9.94));
		studenti.add(new Student("Viktor", "Jankovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Gogoljeva 3, Novi Sad",
				"021/135-463", "viktor.jankovic@mailinator.com", "RA 1/2017",
				LocalDate.parse("01.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 3, Student.Status.B, 7.05));
		studenti.add(new Student("Petra", "Todorovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Njego\u0161eva 2, Novi Sad", "021/903-463", "petra.todorovic@mailinator.com", "RA 5/2017",
				LocalDate.parse("12.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 3, Student.Status.B, 7.32));
		studenti.add(new Student("Andrej", "Stankovi\u0107",
				LocalDate.parse("03.12.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Radoja Domanovi\u0107a 5, Novi Sad", "021/731-067", "andrej.stankovic@mailinator.com", "RA 33/2017",
				LocalDate.parse("19.07.2017.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 3, Student.Status.B, 7.59));
		studenti.add(new Student("Mila", "Risti\u0107",
				LocalDate.parse("03.12.1997.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Vojvode Stepe 183, Beograd", "011/4333-800", "mila.ristic@mailinator.com", "RA 152/2016",
				LocalDate.parse("15.07.2016.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 3, Student.Status.S, 8.71));
		studenti.add(new Student("Pavle", "Kosti\u0107",
				LocalDate.parse("03.12.1997.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "Crnotravska 13, Beograd",
				"011/3130-007", "pavle.kostic@mailinator.com", "RA 104/2016",
				LocalDate.parse("06.07.2016.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 3, Student.Status.S, 8.37));
		studenti.add(new Student("Lena", "Kova\u010devi\u0107",
				LocalDate.parse("03.12.1997.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Bulevar Oslobo\u0111enja 143, Novi Sad", "021/5333-801", "lena.kovacevic@mailinator.com", "RA 1/2016",
				LocalDate.parse("01.07.2016.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 4, Student.Status.B, 8.53));
		studenti.add(new Student("Filip", "\u017Divkovi\u0107",
				LocalDate.parse("03.12.1997.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "1300 Kaplara, \u0160abac",
				"015/333-500", "filip.zivkovic@mailinator.com", "RA 5/2016",
				LocalDate.parse("21.07.2016.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 4, Student.Status.B, 6.74));
		studenti.add(new Student("Tara", "Dmiitrijevi\u0107",
				LocalDate.parse("03.12.1996.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Milovana Gli\u0161i\u0107a, Valjevo", "014/303-007", "tara.dimitrijevic@mailinator.com", "RA 33/2015",
				LocalDate.parse("23.07.2015.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 4, Student.Status.S, 9.45));
		studenti.add(new Student("Vasilije", "Mici\u0107",
				LocalDate.parse("03.12.1996.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Vuka Karad\u017ei\u0107a, Loznica", "015/101-909", "vasilije.micic@mailinator.com", "RA 102/2015",
				LocalDate.parse("04.07.2015.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 4, Student.Status.S, 6.36));
		studenti.add(new Student("Lenka", "Jovi\u0107",
				LocalDate.parse("03.12.1997.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),
				"Bulevar Mihajla Pupina, Novi Sad", "021/431-500", "lenka.jovic@mailinator.com", "RA 244/2016",
				LocalDate.parse("07.07.2016.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), 4, Student.Status.S, 9.68));
	}

	private void studentiPredmetiMock() {
		Predmet predmet = null;
		Student student = null;

		predmet = findPredmetById("OP301");
		student = findStudentByInd("RA 1/2019");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 5/2019");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 3/2019");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 2/2019");
		predmet.addStudent(student);
		student.addPredmet(predmet);

		predmet = findPredmetById("DM881");
		student = findStudentByInd("RA 3/2018");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 15/2018");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 133/2017");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 122/2017");
		predmet.addStudent(student);
		student.addPredmet(predmet);

		predmet = findPredmetById("PP007");
		student = findStudentByInd("RA 1/2017");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 5/2017");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 33/2017");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 152/2016");
		predmet.addStudent(student);
		student.addPredmet(predmet);

		predmet = findPredmetById("RVP33");
		student = findStudentByInd("RA 1/2016");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 5/2016");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 33/2015");
		predmet.addStudent(student);
		student.addPredmet(predmet);
		student = findStudentByInd("RA 102/2015");
		predmet.addStudent(student);
		student.addPredmet(predmet);
	}

}
