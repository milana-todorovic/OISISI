/**
 * 
 */
package view.tables.profesori;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Profesor;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1362931699790512868L;

	public static final Map<String, Integer> validKeywords = Arrays
			.stream(new Object[][] { { "ime", 0 }, { "ime profesora", 0 }, { "prezime", 1 }, { "prezime profesora", 1 },
					{ "datum rodjenja", 2 }, { "datum ro\u0111enja", 2 }, { "adresa", 3 }, { "adresa stanovanja", 3 },
					{ "telefon", 4 }, { "broj telefona", 4 }, { "kontakt", 4 }, { "kontakt telefon", 4 },
					{ "email", 5 }, { "e-mail", 5 }, { "email adresa", 5 }, { "e-mail adresa", 5 },
					{ "adresa kancelarije", 6 }, { "kancelarija", 6 }, { "broj li\u010Dne karte", 7 },
					{ "broj licne karte", 7 }, { "licna", 7 }, { "li\u010Dna", 7 }, { "broj li\u010Dne", 7 },
					{ "broj licne", 7 }, { "li\u010Dna karta", 7 }, { "licna karta", 7 }, { "titula", 8 },
					{ "zvanje", 9 } })
			.collect(Collectors.toMap(keyMapper -> (String) keyMapper[0], valueMapper -> (Integer) valueMapper[1]));

	private final String[] columnNames = { "Ime", "Prezime", "Datum ro\u0111enja", "Adresa stanovanja",
			"Kontakt telefon", "E-mail adresa", "Adresa kancelarije", "Broj li\u010Dne karte", "Titula", "Zvanje",
			"Predmeti" };

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == columnNames.length - 1)
			return true;
		else
			return false;
	}

	@Override
	public int getRowCount() {
		return MainController.getInstance().getProfesoriController().getBrojProfesora();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int c) {
		// row sorter poziva ovo prije nego sto provjeri da li je tabela prazna
		if (this.getRowCount() != 0) {
			return getValueAt(0, c).getClass();
		} else {
			return String.class;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Profesor profesor = MainController.getInstance().getProfesoriController().getProfesor(rowIndex);
		switch (columnIndex) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getDatumRodjenja();
		case 3:
			return profesor.getAdresa();
		case 4:
			return profesor.getKontaktTelefon();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrojLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		case 10:
			return profesor.getPredmeti();
		default:
			return "";
		}
	}
}
