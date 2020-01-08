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
 * @author Ana Perisic ra1-2017
 *
 */
public class Student implements Serializable {

	public static enum Status {
		B, S;

		private String[] status = { "B", "S" };

		@Override
		public String toString() {
			return status[this.ordinal()];
		}

	}

	private static final long serialVersionUID = -8950945688057768215L;

	public static final String[] keys = { "Ime", "Prezime", "Datum rodjenja", "Adresa stanovanja", "Broj telefona",
			"Email adresa", "Broj indeksa", "Datum upisa", "Godina studija", "Status", "Prosek" };

	private String ime;
	private String prezime;
	private LocalDate datumRodjenja;
	private String adresaStanovanja;
	private String brTelefona;
	private String emailAdresa;
	private String brIndeksa;
	private LocalDate datumUpisa;
	private Integer trenutnaGodStudija;
	private Status status;
	private Double prosecnaOcena;
	private List<Predmet> predmeti;

	public Student(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String brTelefona,
			String emailAdresa, String brIndeksa, LocalDate datumUpisa, Integer trenutnaGodStudija, Status status,
			Double prosecnaOcena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.brTelefona = brTelefona;
		this.emailAdresa = emailAdresa;
		this.brIndeksa = brIndeksa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.status = status;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Student(Map<String, Object> values) {
		this.ime = (String) values.get(keys[0]);
		this.prezime = (String) values.get(keys[1]);
		this.datumRodjenja = (LocalDate) values.get(keys[2]);
		this.adresaStanovanja = (String) values.get(keys[3]);
		this.brTelefona = (String) values.get(keys[4]);
		this.emailAdresa = (String) values.get(keys[5]);
		this.brIndeksa = (String) values.get(keys[6]);
		this.datumUpisa = (LocalDate) values.get(keys[7]);
		this.trenutnaGodStudija = (Integer) values.get(keys[8]);
		this.status = (Status) values.get(keys[9]);
		this.prosecnaOcena = (Double) values.get(keys[10]);
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
	 * @return the adresaStanovanja
	 */
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	/**
	 * @param adresaStanovanja the adresaStanovanja to set
	 */
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	/**
	 * @return the brTelefona
	 */
	public String getBrTelefona() {
		return brTelefona;
	}

	/**
	 * @param brTelefona the brTelefona to set
	 */
	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	/**
	 * @return the emailAdresa
	 */
	public String getEmailAdresa() {
		return emailAdresa;
	}

	/**
	 * @param emailAdresa the emailAdresa to set
	 */
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	/**
	 * @return the brIndeksa
	 */
	public String getBrIndeksa() {
		return brIndeksa;
	}

	/**
	 * @param brIndeksa the brIndeksa to set
	 */
	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	/**
	 * @return the datumUpisa
	 */
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}

	/**
	 * @param datumUpisa the datumUpisa to set
	 */
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	/**
	 * @return the trenutnaGodStudija
	 */
	public Integer getTrenutnaGodStudija() {
		return trenutnaGodStudija;
	}

	/**
	 * @param trenutnaGodStudija the trenutnaGodStudija to set
	 */
	public void setTrenutnaGodStudija(Integer trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the prosecnaOcena
	 */
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}

	/**
	 * @param prosecnaOcena the prosecnaOcena to set
	 */
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
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
	 * Dodavanje predmeta koji student slusa.
	 * 
	 * @param predmet
	 */
	public void addPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}

	/**
	 * Postavlja polje na vrijednost iz parametra values, ako values sadrzi kljuc
	 * koji odgovara tom polju.
	 * 
	 * @param values
	 */
	public void set(Map<String, Object> values) {
		this.ime = (values.containsKey(keys[0])) ? (String) values.get(keys[0]) : ime;
		this.prezime = (values.containsKey(keys[1])) ? (String) values.get(keys[1]) : prezime;
		this.datumRodjenja = (values.containsKey(keys[2])) ? (LocalDate) values.get(keys[2]) : datumRodjenja;
		this.adresaStanovanja = (values.containsKey(keys[3])) ? (String) values.get(keys[3]) : adresaStanovanja;
		this.brTelefona = (values.containsKey(keys[4])) ? (String) values.get(keys[4]) : brTelefona;
		this.emailAdresa = (values.containsKey(keys[5])) ? (String) values.get(keys[5]) : emailAdresa;
		this.brIndeksa = (values.containsKey(keys[6])) ? (String) values.get(keys[6]) : brIndeksa;
		this.datumUpisa = (values.containsKey(keys[7])) ? (LocalDate) values.get(keys[7]) : datumUpisa;
		this.trenutnaGodStudija = (values.containsKey(keys[8])) ? (Integer) values.get(keys[8]): trenutnaGodStudija;
		this.status = (values.containsKey(keys[9])) ? (Status) values.get(keys[9]) : status;
		this.prosecnaOcena = (values.containsKey(keys[10])) ? (Double) values.get(keys[10]) : prosecnaOcena;
		this.predmeti = new ArrayList<Predmet>();
	}

	@Override
	public String toString() {
		return brIndeksa + " " + prezime + " " + ime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brIndeksa == null) ? 0 : brIndeksa.hashCode());
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
		Student other = (Student) obj;
		if (brIndeksa == null) {
			if (other.brIndeksa != null)
				return false;
		} else if (!brIndeksa.equals(other.brIndeksa))
			return false;
		return true;
	}

}
