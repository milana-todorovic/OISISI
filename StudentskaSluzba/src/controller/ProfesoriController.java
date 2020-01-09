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

	/**
	 * @return broj profesora unesenih u bazu
	 */
	public int getBrojProfesora() {
		return Database.getInstance().getBrojProfesora();
	}

	/**
	 * @param index
	 * @return profesor na prosledjenom indeksu
	 */
	public Profesor getProfesor(int index) {
		return Database.getInstance().getProfesor(index);
	}

	/**
	 * Metoda koja brise zadatog profesora iz baze.
	 * 
	 * @param index - indeks profesora kog treba obrisati
	 */
	public void remove(int index) {
		Database.getInstance().removeProfesor(index);
	}

	/**
	 * Metoda koja pretrazuje tabelu profesora po zadatim parametrima.
	 * 
	 * @param searchParam - parametri kombinovane pretrage (podrazumeva se da je
	 *                    format i sadrzaj ispravan)
	 */
	public void startSearch(String searchParam) {
		String[] splits = searchParam.split(";");
		ArrayList<RowFilter<ProfesoriTableModel, Integer>> filters = new ArrayList<RowFilter<ProfesoriTableModel, Integer>>();
		Map<String, Integer> keys = ProfesoriTableModel.validKeywords;

		for (String string : splits) {
			int separator = string.indexOf(":");
			filters.add(RowFilter.regexFilter("^(?ui)" + string.substring(separator + 1).trim() + "$",
					keys.get(string.substring(0, separator).trim())));
		}

		RowFilter<ProfesoriTableModel, Integer> filter = RowFilter.andFilter(filters);
		@SuppressWarnings("unchecked")
		TableRowSorter<ProfesoriTableModel> sorter = ((TableRowSorter<ProfesoriTableModel>) MainFrame.getInstance()
				.getRowSorter());
		sorter.setRowFilter(filter);
	}

}
