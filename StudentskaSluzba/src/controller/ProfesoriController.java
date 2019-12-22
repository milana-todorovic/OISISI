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

}
