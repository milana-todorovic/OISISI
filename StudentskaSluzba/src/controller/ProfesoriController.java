/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import model.Database;
import model.Profesor;
import view.MainFrame;
import view.ProfesoriTableModel;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriController {

	public int getBrojProfesora() {
		return Database.getInstance().getBrojProfesora();
	}

	public Profesor getProfesor(int index) {
		return Database.getInstance().getProfesor(index);
	}

	public void remove(int index) {
		Database.getInstance().removeProfesor(index);
	}

	public boolean addProfesor(Map<String, Object> values) {

		if (Database.getInstance().addProfesor(values)) {
			int index = getBrojProfesora() - 1;
			MainFrame.getInstance().cancelSearch();
			MainFrame.getInstance().getTableModel().fireTableRowsInserted(index, index);
			MainFrame.getInstance().setSelectedRow(index);
			return true;
		} else {
			return false;
		}
	}

	public void updateProfesor(Map<String, Object> values) {
		int index = MainFrame.getInstance().getSelectedRow();
		Database.getInstance().updateProfesor(index, values);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(index);
	}

	public void startSearch(String searchParam) {
		String[] splits = searchParam.split(";");
		ArrayList<RowFilter<ProfesoriTableModel, Integer>> filters = new ArrayList<RowFilter<ProfesoriTableModel, Integer>>();
		Map<String, Integer> keys = ProfesoriTableModel.validKeywords;

		for (String string : splits) {
			int separator = string.indexOf(":");
			filters.add(RowFilter.regexFilter("(?ui)" + string.substring(separator + 1).trim(),
					keys.get(string.substring(0, separator).trim())));
		}

		RowFilter<ProfesoriTableModel, Integer> filter = RowFilter.andFilter(filters);
		@SuppressWarnings("unchecked")
		TableRowSorter<ProfesoriTableModel> sorter = ((TableRowSorter<ProfesoriTableModel>) MainFrame.getInstance()
				.getRowSorter());
		sorter.setRowFilter(filter);
	}

	public Profesor findByLicna(String brLicneKarte) {
		return Database.getInstance().findProfesorByLicna(brLicneKarte);
	}

}
