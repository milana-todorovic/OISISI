/**
 * 
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Osoba implements Serializable {

	private static final long serialVersionUID = -3012417119565715978L;
	
	protected String ime;
	protected String prezime;
	protected LocalDate datumRodjenja;
	protected String adresaStanovanja;
	protected String brTelefona;
	protected String emailAdresa;

	public Osoba() {
		super();

		this.ime = "";
		this.prezime = "";
		this.datumRodjenja = LocalDate.now();
		this.adresaStanovanja = "";
		this.brTelefona = "";
		this.emailAdresa = "";
	}

	/**
	 * @param ime
	 * @param prezime
	 * @param datumRodjenja
	 * @param adresaStanovanja
	 * @param brTelefona
	 * @param emailAdresa
	 */
	public Osoba(String ime, String prezime, LocalDate datumRodjenja, String adresaStanovanja, String brTelefona,
			String emailAdresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.brTelefona = brTelefona;
		this.emailAdresa = emailAdresa;
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

}
