/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import model.Database;
import model.Predmet;
import view.MainFrame;
import view.PredmetiTableModel;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetiController {

	/**
	 * @return broj predmeta unesenih u bazu
	 */
	public int getBrojPredmeta() {
		return Database.getInstance().getBrojPredmeta();
	}

	/**
	 * @param index
	 * @return predmet na prosledjenom indeksu
	 */
	public Predmet getPredmet(int index) {
		return Database.getInstance().getPredmet(index);
	}

	/**
	 * @param sifra
	 * @return predmet sa prosledjenom sifrom
	 */
	public Predmet findByID(String sifra) {
		return Database.getInstance().findPredmetById(sifra);
	}

	/**
	 * Metoda koja brise zadati predmet iz baze.
	 * 
	 * @param index - indeks predmeta koji treba obrisati
	 */
	public void remove(int index) {
		Database.getInstance().removePredmet(index);
	}

	/**
	 * Metoda koja dodaje predmet u bazu.
	 * 
	 * @param values
	 * @return indikator uspesnosti dodavanja
	 */
	public boolean addPredmet(Map<String, Object> values) {
		if (Database.getInstance().addPredmet(values)) {
			int index = getBrojPredmeta() - 1;
			// zavrsava se pretraga da bi se dodani predmet sigurno prikazao
			MainFrame.getInstance().cancelSearch();
			MainFrame.getInstance().getTableModel().fireTableRowsInserted(index, index);
			MainFrame.getInstance().setSelectedRow(index);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja azurira trenutno izabrani predmet.
	 * 
	 * @param values
	 */
	public void updatePredmet(Map<String, Object> values) {
		int index = MainFrame.getInstance().getSelectedRow();
		Database.getInstance().updatePredmet(index, values);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(index);
	}

	/**
	 * Metoda koja pretrazuje tabelu predmeta po zadatim parametrima.
	 * 
	 * @param searchParam - parametri kombinovane pretrage (podrazumeva se da je
	 *                    format i sadrzaj ispravan)
	 */
	public void startSearch(String searchParam) {
		String[] splits = searchParam.split(";");
		ArrayList<RowFilter<PredmetiTableModel, Integer>> filters = new ArrayList<RowFilter<PredmetiTableModel, Integer>>();
		Map<String, Integer> keys = PredmetiTableModel.validKeywords;

		for (String string : splits) {
			int separator = string.indexOf(":");
			filters.add(RowFilter.regexFilter("^(?ui)" + string.substring(separator + 1).trim() + "$",
					keys.get(string.substring(0, separator).trim())));
		}

		RowFilter<PredmetiTableModel, Integer> filter = RowFilter.andFilter(filters);
		@SuppressWarnings("unchecked")
		TableRowSorter<PredmetiTableModel> sorter = ((TableRowSorter<PredmetiTableModel>) MainFrame.getInstance()
				.getRowSorter());
		sorter.setRowFilter(filter);
	}

	/**
	 * Prosledjuje podatke o izabranom predmetu dijalogu za dodavanje/izmenu
	 * profesora na predmetu.
	 * 
	 * @param predmet
	 */
	public void launchProfesorNaPredmetuEdit(int predmet) {
		int profesor = Database.getInstance().indeksProfesoraNaPredmetu(predmet);
		MainFrame.getInstance().getDialogHandler().launchProfesorNaPredmetuEdit(profesor);
	}

	/**
	 * Metoda koja azurira profesora na trenutno izabranom predmetu.
	 * 
	 * @param profesor
	 */
	public void izmeniProfesoraNaPredmetu(int profesor) {
		int predmet = MainFrame.getInstance().getSelectedRow();
		Database.getInstance().izmeniProfesoraNaPredmetu(profesor, predmet);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(predmet);
	}

	/**
	 * Metoda koja uklanja profesora sa predmeta na prosledjenom indeksu.
	 * 
	 * @param predmet
	 */
	public void ukloniProfesoraSaPredmeta(int predmet) {
		Database.getInstance().removePredmetProfesor(predmet);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(predmet);
	}

}
