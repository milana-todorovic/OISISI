/**
 * 
 */
package view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Student;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3340702328479443513L;

	public static final Map<String, Integer> validKeywords = Arrays
			.stream(new Object[][] { { "", 0 } /*
												 * TODO ubaciti stvarne kljucne rijeci za pretagu kada bude
												 * implementirana funkcionalnost #pretraga_studenata
												 */ })
			.collect(Collectors.toMap(keyMapper -> (String) keyMapper[0], valueMapper -> (Integer) valueMapper[1]));

	private final String[] columnNames = { "Broj indeksa", "Ime", "Prezime", "Godina", "Status", "Prosek",
			"Datum ro\u0111enja", "Adresa stanovanja", "Broj telefona", "E-mail adresa", "Datum upisa", "Predmeti" };

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == columnNames.length - 1)
			return true;
		else
			return false;
	}

	@Override
	public int getRowCount() {
		return MainController.getInstance().getStudentiController().getBrojStudenata();
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
		if (this.getRowCount() != 0) {
			return getValueAt(0, c).getClass();
		} else {
			return String.class;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Student student = MainController.getInstance().getStudentiController().getStudent(rowIndex);
		switch (columnIndex) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getTrenutnaGodStudija();
		case 4:
			return student.getStatus();
		case 5:
			return student.getProsecnaOcena();
		case 6:
			return student.getDatumRodjenja();
		case 7:
			return student.getAdresaStanovanja();
		case 8:
			return student.getBrTelefona();
		case 9:
			return student.getEmailAdresa();
		case 10:
			return student.getDatumUpisa();
		case 11:
			return student.getPredmeti();
		default:
			return "";
		}
	}

}
