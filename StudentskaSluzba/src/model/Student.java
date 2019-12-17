/**
 * 
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class Student implements Serializable {

	public static enum Status {
		B, S;

		private String[] status = { "Bud\u017Eet", "Samofinansiranje" };

		@Override
		public String toString() {
			return status[this.ordinal()];
		}

	}

	private static final long serialVersionUID = -8950945688057768215L;

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
			String emailAdresa,String brIndeksa,  LocalDate datumUpisa, Integer trenutnaGodStudija, Status status,
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
