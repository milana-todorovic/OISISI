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
public class Predmet implements Serializable {

	private static final long serialVersionUID = 6746715361256232383L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Integer godina;
	private Integer semestar;
	private String profesor; // TODO zamjeniti profesorom kada bude implementirana funkcionalnost #profesor
	private List<String> studenti; // TODO zamjeniti listom studenata kada bude implementirana funkcionalnost
									// #student

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
		this.studenti = new ArrayList<String>();
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
	public String getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the studenti
	 */
	public List<String> getStudenti() {
		return studenti;
	}

	/**
	 * @param studenti the studenti to set
	 */
	public void setStudenti(List<String> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return sifraPredmeta + nazivPredmeta;
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
