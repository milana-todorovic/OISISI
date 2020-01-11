/**
 * 
 */
package view.tables.predmeti;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Predmet;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetiTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5601255137538031760L;

	public static final Map<String, Integer> validKeywords = Arrays
			.stream(new Object[][] { { "sifra", 0 }, { "sifra predmeta", 0 }, { "\u0161ifra", 0 },
					{ "\u0161ifra predmeta", 0 }, { "naziv", 1 }, { "naziv predmeta", 1 }, { "godina", 2 },
					{ "semestar", 3 }, { "profesor", 4 }, { "ime profesora", 4 }, { "broj studenata", 5 },
					{ "br studenata", 5 }, { "br. studenata", 5 } })
			.collect(Collectors.toMap(keyMapper -> (String) keyMapper[0], valueMapper -> (Integer) valueMapper[1]));

	private final String[] columnNames = { "\u0160ifra", "Naziv", "Godina", "Semestar", "Profesor", "Broj studenata",
			"Studenti" };

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// Samo kolona sa dugmicima za prikaz studenata na predmetu je editable
		if (columnIndex == columnNames.length - 1)
			return true;
		else
			return false;
	}

	@Override
	public int getRowCount() {
		return MainController.getInstance().getPredmetiController().getBrojPredmeta();
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
		Predmet predmet = MainController.getInstance().getPredmetiController().getPredmet(rowIndex);
		switch (columnIndex) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getGodina();
		case 3:
			return predmet.getSemestar();
		case 4:
			Object profesor = predmet.getProfesor();
			if (profesor == null)
				return "Nema profesora";
			else
				return profesor.toString();
		case 5:
			return predmet.getStudenti().size();
		case 6:
			return predmet.getStudenti();
		default:
			return "";
		}
	}

}
