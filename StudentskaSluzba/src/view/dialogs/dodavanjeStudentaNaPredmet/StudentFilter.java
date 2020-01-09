/**
 * 
 */
package view.dialogs.dodavanjeStudentaNaPredmet;

import javax.swing.RowFilter;

import model.Predmet;
import model.Student;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentFilter extends RowFilter<MiniStudentiTableModel, Integer> {

	private Predmet predmet;

	/**
	 * @param predmet
	 */
	public StudentFilter(Predmet predmet) {
		super();
		this.predmet = predmet;
	}

	@Override
	public boolean include(Entry<? extends MiniStudentiTableModel, ? extends Integer> entry) {
		Student student = (Student) entry.getValue(0);
		if (student.getTrenutnaGodStudija() != predmet.getGodina())
			return false;
		else if (student.getPredmeti().contains(predmet))
			return false;
		else
			return true;
	}

}
