/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Predmet implements Serializable {

	private static final long serialVersionUID = 6746715361256232383L;

	public static final String[] keys = { "Sifra", "Naziv", "Godina", "Semestar" };

	private String sifraPredmeta;
	private String nazivPredmeta;
	private Integer godina;
	private Integer semestar;
	private Profesor profesor;
	private List<Student> studenti;

	/**
	 * @param sifraPredmeta
	 * @param nazivPredmeta
	 * @param semestar
	 * @param godina
	 */
	public Predmet(String sifraPredmeta, String nazivPredmeta, Integer godina, Integer semestar) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.godina = godina;
		this.semestar = semestar;
		this.profesor = null;
		this.studenti = new ArrayList<Student>();
	}

	/**
	 * Konstruise objekat klase Predmet od vrijednosti sadržanih u parametru values,
	 * uz pretpostavku da values sadrzi sve kljuceve iz niza stringova keys.
	 * 
	 * @param values
	 */
	public Predmet(Map<String, Object> values) {
		this.sifraPredmeta = (String) values.get(keys[0]);
		this.nazivPredmeta = (String) values.get(keys[1]);
		this.godina = (Integer) values.get(keys[2]);
		this.semestar = (Integer) values.get(keys[3]);
		this.profesor = null;
		this.studenti = new ArrayList<Student>();
	}

	/**
	 * @return the sifraPredmeta
	 */
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	/**
	 * @param sifraPredmeta the sifraPredmeta to set
	 */
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	/**
	 * @return the nazivPredmeta
	 */
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	/**
	 * @param nazivPredmeta the nazivPredmeta to set
	 */
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	/**
	 * @return the godina
	 */
	public Integer getGodina() {
		return godina;
	}

	/**
	 * @param godina the godina to set
	 */
	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	/**
	 * @return the semestar
	 */
	public Integer getSemestar() {
		return semestar;
	}

	/**
	 * @param semestar the semestar to set
	 */
	public void setSemestar(Integer semestar) {
		this.semestar = semestar;
	}

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the studenti
	 */
	public List<Student> getStudenti() {
		return studenti;
	}

	/**
	 * @param studenti the studenti to set
	 */
	public void setStudenti(List<Student> studenti) {
		if (studenti == null)
			return;
		this.studenti = studenti;
	}

	/**
	 * @param student
	 */
	public void addStudent(Student student) {
		this.studenti.add(student);
	}

	/**
	 * Postavlja polje na vrijednost iz parametra values, ako values sadrzi kljuc
	 * koji odgovara tom polju.
	 * 
	 * @param values
	 */
	public void set(Map<String, Object> values) {
		this.sifraPredmeta = (values.containsKey(keys[0])) ? (String) values.get(keys[0]) : sifraPredmeta;
		this.nazivPredmeta = (values.containsKey(keys[1])) ? (String) values.get(keys[1]) : nazivPredmeta;
		this.semestar = (values.containsKey(keys[3])) ? (Integer) values.get(keys[3]) : semestar;

		int godinaNewValue = (values.containsKey(keys[2])) ? (Integer) values.get(keys[2]) : godina;
		if (godinaNewValue != this.godina) {
			for (Student student : studenti) {
				student.getPredmeti().remove(this);
			}
			this.studenti = new ArrayList<Student>();
			this.godina = godinaNewValue;
		}
	}

	@Override
	public String toString() {
		return sifraPredmeta + " " + nazivPredmeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifraPredmeta == null) ? 0 : sifraPredmeta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (sifraPredmeta == null) {
			if (other.sifraPredmeta != null)
				return false;
		} else if (!sifraPredmeta.equals(other.sifraPredmeta))
			return false;
		return true;
	}

}
