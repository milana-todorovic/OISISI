/**
 * 
 */
package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Predmet;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetDialog extends JDialog {

	private static final long serialVersionUID = 6152827497814076114L;

	JFrame parent;
	JTextField sifra;
	JTextField naziv;
	JComboBox<String> godina;
	JComboBox<String> semestar;
	JButton dodaj;
	JButton izmeni;

	/**
	 * @param owner
	 */
	public PredmetDialog(JFrame parent) {
		super(parent, "", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;

		int minwidth = this.makeItems();

		// dodaj.setVisible(false);
		// izmeni.setVisible(false);

		this.setMinimumSize(new Dimension(minwidth, 0));
	}

	private int makeItems() {
		this.sifra = new JTextField();
		this.naziv = new JTextField();
		String[] godine = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
		this.godina = new JComboBox<String>(godine);
		String[] semestri = { "I (zimski)", "II (letnji)" };
		this.semestar = new JComboBox<String>(semestri);

		JPanel content = new JPanel(new GridBagLayout());
		content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		this.add(content, BorderLayout.CENTER);

		content.add(new JLabel("\u0160ifra predmeta*: "), new GridBagConstraints(0, 0, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.sifra, new GridBagConstraints(1, 0, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Naziv predmeta*: "), new GridBagConstraints(0, 1, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.naziv, new GridBagConstraints(1, 1, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Godina*: "), new GridBagConstraints(0, 2, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.godina, new GridBagConstraints(1, 2, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Semestar*: "), new GridBagConstraints(0, 3, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.semestar, new GridBagConstraints(1, 3, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(makeAddButton());
		buttons.add(makeSaveChangesButton());
		buttons.add(Box.createHorizontalStrut(15));
		buttons.add(makeReturnButton());

		content.add(buttons, new GridBagConstraints(0, 4, 3, 1, 100, 100, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(15, 10, 0, 10), 0, 0));

		return buttons.getMinimumSize().width + 70;
	}

	private JButton makeAddButton() {
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return dodaj;
	}

	private JButton makeSaveChangesButton() {
		izmeni = new JButton("Sa\u010Duvaj izmene");
		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return izmeni;
	}

	private JButton makeReturnButton() {
		JButton nazad = new JButton("Odustani");

		nazad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		return nazad;
	}

	public void editMode(Predmet predmet) {
		this.setTitle("Izmena predmeta");
		sifra.setText(predmet.getSifraPredmeta());
		naziv.setText(predmet.getNazivPredmeta());
		godina.setSelectedIndex(predmet.getGodina() - 1);
		semestar.setSelectedIndex(predmet.getSemestar() - 1);

		dodaj.setVisible(false);
		izmeni.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 4, d.height / 3);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	public void addMode() {
		this.setTitle("Dodavanje predmeta");
		sifra.setText("");
		naziv.setText("");
		godina.setSelectedIndex(0);
		semestar.setSelectedIndex(0);

		izmeni.setVisible(false);
		dodaj.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 4, d.height / 3);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

}
