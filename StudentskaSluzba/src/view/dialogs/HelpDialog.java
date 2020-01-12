package view.dialogs;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.MainFrame;

/**
 * 
 * @author Ana Perisic ra1-2017
 *
 */
public class HelpDialog extends JDialog {

	private static final long serialVersionUID = 4302591299861839774L;

	public HelpDialog() {
		JDialog helpDialog = new JDialog();

		helpDialog.setTitle("Pomo\u0107");

		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);
		jep.setContentType("text/html");
		jep.setText("<html>" + "<ol>" + "<li>" + "<b>Dodavanje novog studenta</b><br>"
				+ "Dijalog za dodavanje novog studenta je mogu\u0107e otvoriti:" + "<ol>"
				+ "<li>pritiskom na prvi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Fajl</i> (mnemonik <i>F</i>) u traci sa menijima, pa zatim opcije <i>Dodaj</i> (mnemonik <i>D</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>N</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Dodaj</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Dodaj</i> \u0107e biti onemogu\u0107en. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke. "
				+ "Nije dozvoljeno dodavanje ve\u0107 postoje\u0107eg studenta, odnosno studenta sa postoje\u0107im brojem indeksa.</li>"
				+ "<br><li>" + "<b>Izmena postoje\u0107eg studenta</b><br>"
				+ "Nakon odabira \u017eeljenog studenta u tabeli studenata, dijalog za izmenu postoje\u0107eg studenta je mogu\u0107e otvoriti:"
				+ "<ol>" + "<li>pritiskom na drugi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Izmeni</i> (mnemonik <i>I</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>E</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Izmeni</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Izmeni</i> \u0107e biti onemogu\u0107en. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke.</li>"
				+ "<br><li>" + "<b>Brisanje studenta</b><br>"
				+ "Nakon odabira \u017eeljenog studenta u tabeli studenata, brisanje je mogu\u0107e pokrenuti:" + "<ol>"
				+ "<li>pritiskom na tre\u0107i dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Obri\u0161i</i> (mnemonik <i>O</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>D</i>.</li>" + "</ol>"
				+ "Prikazuje se dijalog za potvrdu brisanja.</li>" + "<br><li>" + "<b>Pretraga studenata</b><br>"
				+ "Omogu\u0107ena je kombinovana pretraga studenata. Parametri pretrage se unose u tekstualno polje koje se nalazi u traci sa alatima. "
				+ "Ukoliko unos nije validan, pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke."
				+ "<br> " + "Svaki parametar pretrage se unosi u formatu <i>klju\u010dna re\u010d:vrednost</i>. "
				+ "Mogu\u0107e je uneti proizvoljno mnogo parametara pretrage razdvojenih znakom <i>\";\"</i>. "
				+ "Bi\u0107e prikazani samo oni entiteti koji zadovoljavaju sve unete parametre pretrage. " + "<br> "
				+ "Dozvoljene klju\u010dne re\u010di su: \"indeks\", \"broj indeksa\", \"ime\", \"ime studenta\", \"prezime\", "
				+ "\"prezime studenta\", \"godina\", \"trenutna godina\", \"godina studija\", \"trenutna godina studija\", \"status\", "
				+ "\"status studenta\", \"prosek\", \"prosecna ocena\", \"prose\u010Dna ocena\", \"datum ro\u0111enja\", \"datum rodjenja\", "
				+ "\"adresa\", \"adresa stanovanja\", \"telefon\", \"broj telefona\", \"kontakt telefon\", \"kontakt\", \"email\", \"e-mail\", "
				+ "\"email adresa\", \"e-mail adresa\", \"datum upisa\". " + "<br> "
				+ "Kada su parametri pravilno uneseni, pretragu je mogu\u0107e pokrenuti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica lupe),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>F</i>.</li>" + "</ol>"
				+ "Dok je pretraga aktivna, umesto dugmi\u0107a za pokretanje pretrage bi\u0107e prikazan dugmi\u0107 za zaustavljanje pretrage. "
				+ "Pretragu je mogu\u0107e zaustaviti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica znaka x),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>X</i>.</li>" + "</ol>" + "</li>" + "<li>"
				+ "<b>Sortiranje studenta</b><br>"
				+ "Mogu\u0107e je sortirati studente u rastu\u0107em i opadaju\u0107em redosledu. "
				+ "Studenti u tabeli se mogu sortirati po: broju indeksa, imenu, prezimenu, datumu ro\u0111enja, datumu upisa, statusu i proseku. Kriterijum po kome su sortirani studenti bira se pritiskom na zaglavlje odgovaraju\u0107e kolone.</li>"
				+ "<br><li>" + "<b>Dodavanje studenta na predmet</b><br>"
				+ "Ovu funkcionalnost je mogu\u0107e pokrenuti isklju\u010divo iz kartice <i>Predmeti</i>, "
				+ "pritiskom na \u010detvrti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>S</i>. "
				+ "Na predmet je mogu\u0107e dodati samo one studente koji su odgovaraju\u0107a godina studija, "
				+ "i koji ne slu\u0161aju ve\u0107 odabrani predmet. "
				+ "U otvorenom dijalogu bi\u0107e prikazani samo studenti koje je mogu\u0107e dodati na \u017eeljeni predmet. "
				+ "Unutar dijaloga je potrebno odabrati \u017eeljenog studenta iz prikazane liste studenata, a zatim pritisnuti dugme <i>Sa\u010Duvaj</i>. "
				+ "Listu studenata je mogu\u0107e pretra\u017eiti unosom teksta u polje koje se nalazi u dijalogu.</li><br>"
				+ "<li>" + "<b>Brisanje studenta sa predmeta</b><br>"
				+ "Pritiskom na dugmi\u0107 <i>Prika\u017ei</i> u tabeli studenata, "
				+ "otvara se dijalog koji sadr\u017ei listu predmeta koje odabrani student slu\u0161a. "
				+ "Brisanje veze izme\u0111u studenta i predmeta je mogu\u0107e odabirom \u017eeljenog predmeta iz prikazane liste, "
				+ "a zatim pritiskom na dugme <i>Obri\u0161i</i>.</li>" + "</ol>" + "</html>");
		JEditorPane jep1 = new JEditorPane();
		jep1.setEditable(false);
		jep1.setContentType("text/html");
		jep1.setText("<html>" + "<ol>" + "<li>" + "<b>Dodavanje novog profesora</b><br>"
				+ "Dijalog za dodavanje novog profesora je mogu\u0107e otvoriti:" + "<ol>"
				+ "<li>pritiskom na prvi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Fajl</i> (mnemonik <i>F</i>) u traci sa menijima, pa zatim opcije <i>Dodaj</i> (mnemonik <i>D</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>N</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Dodaj</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Dodaj</i> \u0107e biti onemogu\u0107en. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke. "
				+ "Nije dozvoljeno dodavanje ve\u0107 postoje\u0107eg profesora, odnosno profesora sa postoje\u0107im brojem li\u010dne karte.</li>"
				+ "<br><li>" + "<b>Izmena postoje\u0107eg profesora</b><br>"
				+ "Nakon odabira \u017eeljenog profesora u tabeli profesora, dijalog za izmenu postoje\u0107eg profesora je mogu\u0107e otvoriti:"
				+ "<ol>" + "<li>pritiskom na drugi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Izmeni</i> (mnemonik <i>I</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>E</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Izmeni</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Izmeni</i> \u0107e biti onemogu\u0107en. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke.</li>"
				+ "<br><li>" + "<b>Brisanje profesora</b><br>"
				+ "Nakon odabira \u017eeljenog profesora u tabeli profesora, brisanje je mogu\u0107e pokrenuti:"
				+ "<ol>" + "<li>pritiskom na tre\u0107i dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Obri\u0161i</i> (mnemonik <i>O</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>D</i>.</li>" + "</ol>"
				+ "Prikazuje se dijalog za potvrdu brisanja.</li>" + "<br><li>" + "<b>Pretraga profesora</b><br>"
				+ "Omogu\u0107ena je kombinovana pretraga profesora. Parametri pretrage se unose u tekstualno polje koje se nalazi u traci sa alatima. "
				+ "Ukoliko unos nije validan, pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke."
				+ "<br> " + "Svaki parametar pretrage se unosi u formatu <i>klju\u010dna re\u010d:vrednost</i>. "
				+ "Mogu\u0107e je uneti proizvoljno mnogo parametara pretrage razdvojenih znakom <i>\";\"</i>. "
				+ "Bi\u0107e prikazani samo oni entiteti koji zadovoljavaju sve unete parametre pretrage. " + "<br> "
				+ "Dozvoljene klju\u010dne re\u010di su: \"ime\", \"ime profesora\", \"prezime\", \"prezime profesora\", \"datum rodjenja\", \"datum ro\u0111enja\", \"adresa\", "
				+ "\"adresa stanovanja\", \"telefon\", \"broj telefona\", \"kontakt\", \"kontakt telefon\", \"email\", \"e-mail\", \"email adresa\", \"e-mail adresa\",  "
				+ "\"adresa kancelarije\", \"kancelarija\", \"broj li\u010Dne karte\", \"broj licne karte\", \"licna\", \"li\u010Dna\", \"broj li\u010Dne\",  "
				+ "\"broj licne\", \"li\u010Dna karta\", \"licna karta\", \"titula\", \"zvanje\"." + "<br> "
				+ "Kada su parametri pravilno uneseni, pretragu je mogu\u0107e pokrenuti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica lupe),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>F</i>.</li>" + "</ol>"
				+ "Dok je pretraga aktivna, umesto dugmi\u0107a za pokretanje pretrage bi\u0107e prikazan dugmi\u0107 za zaustavljanje pretrage. "
				+ "Pretragu je mogu\u0107e zaustaviti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica znaka x),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>X</i>.</li>" + "</ol>" + "</li>" + "<br><li>"
				+ "<b>Sortiranje profesora</b><br>"
				+ "Mogu\u0107e je sortirati profesore u rastu\u0107em i opadaju\u0107em redosledu. "
				+ "Profesori u tabeli se mogu sortirati po: imenu, prezimenu, i datumu ro\u0111enja. Kriterijum po kome su sortirani profesori bira se pritiskom na zaglavlje odgovaraju\u0107e kolone.</li>"
				+ "<br><li>" + "<b>Dodavanje/izmena profesora na predmetu</b><br>"
				+ "Ovu funkcionalnost je mogu\u0107e pokrenuti islju\u010divo iz kartice <i>Predmeti</i>, "
				+ "pritiskom na peti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>P</i>. "
				+ "Unutar dijaloga je potrebno odabrati \u017eeljenog profesora iz prikazane liste profesora, a zatim pritisnuti dugme <i>Sa\u010duvaj</i>. "
				+ "Ako je ve\u0107 dodat profesor na predmet, on \u0107e biti odabran u listi kada se dijalog otvori."
				+ "Listu profesora je mogu\u0107e pretra\u017eiti unosom teksta u polje koje se nalazi u dijalogu.</li>"
				+ "<br><li>" + "<b>Brisanje profesora sa predmeta</b><br>"
				+ "Pritiskom na dugmi\u0107 <i>Prika\u017ei</i> u tabeli profesora, "
				+ "otvara se dijalog koji sadr\u017ei listu predmeta koje odabrani profesor predaje. "
				+ "Brisanje veze izme\u0111u profesora i predmeta je mogu\u0107e odabirom \u017eeljenog predmeta iz prikazane liste, "
				+ "a zatim pritiskom na dugme <i>Obri\u0161i</i>."
				+ "Profesora je mogu\u0107e obrisati i iz kartice <i>Predmeti</i>, pritiskom na \u0161esti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>R</i>."
				+ "</li>" + "</ol>" + "</html>");
		JEditorPane jep2 = new JEditorPane();
		jep2.setEditable(false);
		jep2.setContentType("text/html");
		jep2.setText("<html>" + "<ol>" + "<li>" + "<b>Dodavanje novog predmeta</b><br>"
				+ "Dijalog za dodavanje novog predmeta je mogu\u0107e otvoriti:" + "<ol>"
				+ "<li>pritiskom na prvi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Fajl</i> (mnemonik <i>F</i>) u traci sa menijima, pa zatim opcije <i>Dodaj</i> (mnemonik <i>D</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>N</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Dodaj</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Dodaj</i> ce biti onemogucen. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke. "
				+ "Nije dozvoljeno dodavanje ve\u0107 postoje\u0107eg predmeta, odnosno predmeta sa postoje\u0107om \u0161ifrom.</li>"
				+ "<br><li>" + "<b>Izmena postoje\u0107eg predmeta</b><br>"
				+ "Nakon odabira \u017eeljenog predmeta u tabeli predmeta, dijalog za izmenu postoje\u0107eg predmeta je mogu\u0107e otvoriti:"
				+ "<ol>" + "<li>pritiskom na drugi dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Izmeni</i> (mnemonik <i>I</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>E</i>.</li>" + "</ol>"
				+ "Dijalog sadr\u017ei polja za unos podataka, i dugmi\u0107e <i>Sa\u010Duvaj izmene</i> i <i>Odustani</i>. "
				+ "Ukoliko polja u dijalogu nisu validno popunjena, pritisak na dugme <i>Sa\u010Duvaj izmene</i> \u0107e biti onemogu\u0107en. "
				+ "Pored polja koje nije validno popunjeno pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke.</li>"
				+ "<br><li>" + "<b>Brisanje predmeta</b><br>"
				+ "Nakon odabira \u017eeljenog predmeta u tabeli predmeta, brisanje je mogu\u0107e pokrenuti:" + "<ol>"
				+ "<li>pritiskom na tre\u0107i dugmi\u0107 u traci sa alatima,</li>"
				+ "<li>odabirom menija <i>Izmeni</i> (mnemonik <i>I</i>) u traci sa menijima, pa zatim opcije <i>Obri\u0161i</i> (mnemonik <i>O</i>),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>D</i>.</li>" + "</ol>"
				+ "Prikazuje se dijalog za potvrdu brisanja.</li>" + "<br><li>" + "<b>Pretraga predmeta</b><br>"
				+ "Omogu\u0107ena je kombinovana pretraga predmeta. Parametri pretrage se unose u tekstualno polje koje se nalazi u traci sa alatima. "
				+ "Ukoliko unos nije validan, pojavi\u0107e se oznaka gre\u0161ke. "
				+ "Mogu\u0107e je prikazati poruku o vrsti gre\u0161ke pozicioniranjem kursora mi\u0161a na oznaku gre\u0161ke."
				+ "<br> " + "Svaki parametar pretrage se unosi u formatu <i>klju\u010dna re\u010d:vrednost</i>. "
				+ "Mogu\u0107e je uneti proizvoljno mnogo parametara pretrage razdvojenih znakom <i>\";\"</i>. "
				+ "Bi\u0107e prikazani samo oni entiteti koji zadovoljavaju sve unete parametre pretrage. " + "<br> "
				+ "Dozvoljene klju\u010dne re\u010di su: \"sifra\", \"sifra predmeta\", \"\u0161ifra\", \"\u0161ifra predmeta\", \"naziv\", \"naziv predmeta\", \"godina\", "
				+ "\"semestar\", \"profesor\", \"ime profesora\", \"broj studenata\", \"br studenata\", \"br. studenata\"."
				+ "<br> " + "Kada su parametri pravilno uneseni, pretragu je mogu\u0107e pokrenuti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica lupe),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>F</i>.</li>" + "</ol>"
				+ "Dok je pretraga aktivna, umesto dugmi\u0107a za pokretanje pretrage bi\u0107e prikazan dugmi\u0107 za zaustavljanje pretrage. "
				+ "Pretragu je mogu\u0107e zaustaviti:" + "<ol>"
				+ "<li>pritiskom na posledji dugmi\u0107 u traci sa alatima (ikonica znaka x),</li>"
				+ "<li>pre\u010dicom <i>Ctrl</i>+<i>X</i>.</li>" + "</ol>" + "</li>" + "<br><li>"
				+ "<b>Sortiranje predmeta</b><br>"
				+ "Mogu\u0107e je sortirati predmete u rastu\u0107em i opadaju\u0107em redosledu. "
				+ "predmeti u tabeli se mogu sortirati po: \u0161ifri, nazivu, godini i semestru. Kriterijum po kome su sortirani predmeti bira se pritiskom na zaglavlje odgovaraju\u0107e kolone.</li>"
				+ "<br><li>" + "<b>Dodavanje studenta na predmet</b><br>"
				+ "Ovu funkcionalnost je mogu\u0107e pokrenuti islju\u010divo iz kartice <i>Predmeti</i>, "
				+ "pritiskom na \u010detvrti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>S</i>. "
				+ "Na predmet je mogu\u0107e dodati samo one studente koji su odgovaraju\u0107a godina studija, "
				+ "i koji ne slu\u0161aju ve\u0107 odabrani predmet. "
				+ "U otvorenom dijalogu bi\u0107e prikazani samo studenti koje je mogu\u0107e dodati na \u017eeljeni predmet. "
				+ "Unutar dijaloga je potrebno odabrati \u017eeljenog studenta iz prikazane liste studenata, a zatim pritisnuti dugme <i>Sa\u010Duvaj</i>. "
				+ "Listu studenata je mogu\u0107e pretra\u017eiti unosom teksta u polje koje se nalazi u dijalogu.</li><br>"
				+ "<li>" + "<b>Brisanje studenta sa predmeta</b><br>"
				+ "Pritiskom na dugmi\u0107 <i>Prika\u017ei</i> u tabeli studenata, "
				+ "otvara se dijalog koji sadr\u017ei listu predmeta koje odabrani student slu\u0161a. "
				+ "Brisanje veze izme\u0111u studenta i predmeta je mogu\u0107e odabirom \u017eeljenog predmeta iz prikazane liste, "
				+ "a zatim pritiskom na dugme <i>Obri\u0161i</i>. Na sli\u010dan na\u010din je mogu\u0107e izvr\u0161iti brisanje i iz kartice <i>Predmeti</i>.</li><br>"
				+ "<li><b>Dodavanje/izmena profesora na predmetu</b><br>"
				+ "Ovu funkcionalnost je mogu\u0107e pokrenuti islju\u010divo iz kartice <i>Predmeti</i>, "
				+ "pritiskom na peti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>P</i>. "
				+ "Unutar dijaloga je potrebno odabrati \u017eeljenog profesora iz prikazane liste predmeta, a zatim pritisnuti dugme <i>Sa\u010duvaj</i>. "
				+ "Ako je ve\u0107 dodat profesor na predmet, on \u0107e biti odabran u listi kada se dijalog otvori."
				+ "Listu profesora je mogu\u0107e pretra\u017eiti unosom teksta u polje koje se nalazi u dijalogu.</li>"
				+ "<br><li>" + "<b>Brisanje profesora sa predmeta</b><br>"
				+ "Pritiskom na dugmi\u0107 <i>Prika\u017ei</i> u tabeli predmeta, "
				+ "otvara se dijalog koji sadr\u017ei listu predmeta koje odabrani predmet predaje. "
				+ "Brisanje veze izme\u0111u profesora i predmeta je mogu\u0107e odabirom \u017eeljenog predmeta iz prikazane liste, "
				+ "a zatim pritiskom na dugme <i>Obri\u0161i</i>."
				+ "Profesora je mogu\u0107e obrisati i iz kartice <i>Predmeti</i>, pritiskom na \u0161esti dugmi\u0107 u traci sa alatima ili pre\u010dicom <i>Ctrl</i>+<i>R</i>."
				+ "</li>" + "</ol>" + "</html>");

		JScrollPane scroll = new JScrollPane(jep);
		JPanel content = new JPanel(new BorderLayout());
		content.add(scroll, BorderLayout.CENTER);

		JScrollPane scroll1 = new JScrollPane(jep1);
		JPanel content1 = new JPanel(new BorderLayout());
		content1.add(scroll1, BorderLayout.CENTER);

		JScrollPane scroll2 = new JScrollPane(jep2);
		JPanel content2 = new JPanel(new BorderLayout());
		content2.add(scroll2, BorderLayout.CENTER);

		JTabbedPane tabs = new JTabbedPane();

		tabs.addTab("Studenti", content);
		tabs.addTab("Profesori", content1);
		tabs.addTab("Predmeti", content2);

		helpDialog.add(tabs);
		helpDialog.pack();
		helpDialog.setSize(800, 600);
		helpDialog.setLocationRelativeTo(MainFrame.getInstance());
		helpDialog.setVisible(true);
	}

}
