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
public class Profesor implements Serializable {

	private static final long serialVersionUID = -3025873770799257742L;

	public static final String[] keys = { "Ime", "Prezime", "Datum rodjenja", "Adresa stanovanja", "Broj telefona",
			"Email adresa", "Adresa kancelarije", "Broj licne karte", "Titula", "Zvanje" };

	private String ime;
	private String prezime;
	private LocalDate datumRodjenja;
	private String adresa;
	private String kontaktTelefon;
	private String email;
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
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Profesor(Map<String, Object> values) {
		this.ime = (String) values.get(keys[0]);
		this.prezime = (String) values.get(keys[1]);
		this.datumRodjenja = (LocalDate) values.get(keys[2]);
		this.adresa = (String) values.get(keys[3]);
		this.kontaktTelefon = (String) values.get(keys[4]);
		this.email = (String) values.get(keys[5]);
		this.adresaKancelarije = (String) values.get(keys[6]);
		this.brojLicneKarte = (String) values.get(keys[7]);
		this.titula = (String) values.get(keys[8]);
		this.zvanje = (String) values.get(keys[9]);
		this.predmeti = new ArrayList<Predmet>();
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * @param prezime the prezime to set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * @return the datumRodjenja
	 */
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	/**
	 * @param datumRodjenja the datumRodjenja to set
	 */
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * @return the kontaktTelefon
	 */
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	/**
	 * @param kontaktTelefon the kontaktTelefon to set
	 */
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
		this.adresa = (values.containsKey(keys[3])) ? (String) values.get(keys[3]) : adresa;
		this.kontaktTelefon = (values.containsKey(keys[4])) ? (String) values.get(keys[4]) : kontaktTelefon;
		this.email = (values.containsKey(keys[5])) ? (String) values.get(keys[5]) : email;
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
