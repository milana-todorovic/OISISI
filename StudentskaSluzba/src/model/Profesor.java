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
 *
 */
public class Profesor extends Osoba implements Serializable {

	private static final long serialVersionUID = -3025873770799257742L;

	public static final String[] keys = { "Ime", "Prezime", "Datum rodjenja", "Adresa stanovanja", "Broj telefona",
			"Email adresa", "Adresa kancelarije", "Broj licne karte", "Titula", "Zvanje" };

	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private List<Predmet> predmeti;

	/**
	 * @param ime
	 * @param prezime
	 * @param datumRodjenja
	 * @param adresa
	 * @param kontaktTelefon
	 * @param email
	 * @param adresaKancelarije
	 * @param brojLicneKarte
	 * @param titula
	 * @param zvanje
	 */
	public Profesor(String ime, String prezime, LocalDate datumRodjenja, String adresa, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		super(ime, prezime, datumRodjenja, adresa, kontaktTelefon, email);
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Profesor(Map<String, Object> values) {
		super();
		this.ime = (String) values.get(keys[0]);
		this.prezime = (String) values.get(keys[1]);
		this.datumRodjenja = (LocalDate) values.get(keys[2]);
		this.adresaStanovanja = (String) values.get(keys[3]);
		this.brTelefona = (String) values.get(keys[4]);
		this.emailAdresa = (String) values.get(keys[5]);
		this.adresaKancelarije = (String) values.get(keys[6]);
		this.brojLicneKarte = (String) values.get(keys[7]);
		this.titula = (String) values.get(keys[8]);
		this.zvanje = (String) values.get(keys[9]);
		this.predmeti = new ArrayList<Predmet>();
	}

	/**
	 * @return the adresaKancelarije
	 */
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	/**
	 * @param adresaKancelarije the adresaKancelarije to set
	 */
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	/**
	 * @return the brojLicneKarte
	 */
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	/**
	 * @param brojLicneKarte the brojLicneKarte to set
	 */
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	/**
	 * @return the titula
	 */
	public String getTitula() {
		return titula;
	}

	/**
	 * @param titula the titula to set
	 */
	public void setTitula(String titula) {
		this.titula = titula;
	}

	/**
	 * @return the zvanje
	 */
	public String getZvanje() {
		return zvanje;
	}

	/**
	 * @param zvanje the zvanje to set
	 */
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	/**
	 * @return the predmeti
	 */
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	/**
	 * @param predmeti the predmeti to set
	 */
	public void setPredmeti(List<Predmet> predmeti) {
		if (predmeti == null)
			return;
		this.predmeti = predmeti;
	}

	/**
	 * @param predmet
	 */
	public void addPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}

	@Override
	public String toString() {
		return brojLicneKarte + " " + ime + " " + prezime;
	}

	public void set(Map<String, Object> values) {
		this.ime = (values.containsKey(keys[0])) ? (String) values.get(keys[0]) : ime;
		this.prezime = (values.containsKey(keys[1])) ? (String) values.get(keys[1]) : prezime;
		this.datumRodjenja = (values.containsKey(keys[2])) ? (LocalDate) values.get(keys[2]) : datumRodjenja;
		this.adresaStanovanja = (values.containsKey(keys[3])) ? (String) values.get(keys[3]) : adresaStanovanja;
		this.brTelefona = (values.containsKey(keys[4])) ? (String) values.get(keys[4]) : brTelefona;
		this.emailAdresa = (values.containsKey(keys[5])) ? (String) values.get(keys[5]) : emailAdresa;
		this.adresaKancelarije = (values.containsKey(keys[6])) ? (String) values.get(keys[6]) : adresaKancelarije;
		this.brojLicneKarte = (values.containsKey(keys[7])) ? (String) values.get(keys[7]) : brojLicneKarte;
		this.titula = (values.containsKey(keys[8])) ? (String) values.get(keys[8]) : titula;
		this.zvanje = (values.containsKey(keys[9])) ? (String) values.get(keys[9]) : zvanje;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brojLicneKarte == null) ? 0 : brojLicneKarte.hashCode());
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
		Profesor other = (Profesor) obj;
		if (brojLicneKarte == null) {
			if (other.brojLicneKarte != null)
				return false;
		} else if (!brojLicneKarte.equals(other.brojLicneKarte))
			return false;
		return true;
	}

}
