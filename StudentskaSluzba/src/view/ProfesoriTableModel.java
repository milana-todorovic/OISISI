/**
 * 
 */
package view;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Profesor;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1362931699790512868L;
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
