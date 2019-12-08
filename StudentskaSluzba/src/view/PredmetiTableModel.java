/**
 * 
 */
package view;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Predmet;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetiTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5601255137538031760L;

	private String[] columnNames = { "\u0160ifra", "Naziv", "Godina", "Semestar", "Profesor", "Broj studenata", "Studenti" };

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// Samo kolona sa dugmicima za prikaz studenata na predmetu je editable
		if (columnIndex == 6)
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
		return getValueAt(0, c).getClass();
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
			return null;
		}
	}

}
