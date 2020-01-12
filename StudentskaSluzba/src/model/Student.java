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
public class Student extends Osoba implements Serializable {

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

	private String brIndeksa;
	private LocalDate datumUpisa;
	private Integer trenutnaGodStudija;
	private Status status;
	private Double prosecnaOcena;
	private List<Predmet> predmeti;

	public Student(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String brTelefona,
			String emailAdresa, String brIndeksa, LocalDate datumUpisa, Integer trenutnaGodStudija, Status status,
			Double prosecnaOcena) {
		super(ime, prezime, datumRodjenja, adresaStanovanja, brTelefona, emailAdresa);
		this.brIndeksa = brIndeksa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.status = status;
		this.predmeti = new ArrayList<Predmet>();
	}

	public Student(Map<String, Object> values) {
		super();
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
		this.status = (values.containsKey(keys[9])) ? (Status) values.get(keys[9]) : status;
		this.prosecnaOcena = (values.containsKey(keys[10])) ? (Double) values.get(keys[10]) : prosecnaOcena;

		Integer godinaNewValue = (values.containsKey(keys[8])) ? (Integer) values.get(keys[8]) : trenutnaGodStudija;
		if (!godinaNewValue.equals(this.trenutnaGodStudija)) {
			for (Predmet predmet : predmeti) {
				predmet.getStudenti().remove(this);
			}
			this.predmeti = new ArrayList<Predmet>();
			this.trenutnaGodStudija = godinaNewValue;
		}
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
