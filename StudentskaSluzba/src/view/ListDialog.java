/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.MainController;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ListDialog extends JDialog {

	private static final long serialVersionUID = 8545980548311697543L;

	JFrame parent;
	JList<Object> list;

	/**
	 * Konstruktor koji pravi instancu dijaloga bez dodatih podataka (koristiti ako
	 * ce postojati samo jedna instanca napravljena na pocetku izvrsavanja).
	 * 
	 * @param parent
	 */
	public ListDialog(JFrame parent) {
		super(parent, "", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;
		int minwidth = this.makeItems();

		this.setMinimumSize(new Dimension(minwidth, 0));
	}

	/**
	 * Inicijalizacija elemenata sa praznom listom, koristiti sa konstruktorom
	 * ListDialog(JFrame parent).
	 * 
	 * @return minimalna sirina dijaloga
	 */
	private int makeItems() {
		// JList
		DefaultListModel<Object> listModel = new DefaultListModel<Object>();
		list = new JList<Object>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellHeight(25);
		JScrollPane scroll = new JScrollPane(list);

		// panel sa dugmicima
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.add(Box.createHorizontalGlue());
		bottom.add(this.makeDeleteButton());
		bottom.add(Box.createHorizontalStrut(15));
		bottom.add(this.makeReturnButton());

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
		content.add(scroll, BorderLayout.CENTER);
		content.add(bottom, BorderLayout.SOUTH);

		this.add(content, BorderLayout.CENTER);

		return content.getMinimumSize().width + 18;
	}

	/**
	 * Azurira sadrzaj liste i prikazuje prozor.
	 * 
	 * @param title
	 * @param value - podaci koje treba prikazati
	 */
	public void show(String title, List<?> value) {
		this.setTitle(title);
		DefaultListModel<Object> listModel = (DefaultListModel<Object>) list.getModel();
		listModel.removeAllElements();
		for (Object val : value) {
			listModel.addElement(val);
		}

		Dimension d = parent.getSize();
		this.setSize(d.width / 4, d.height / 2);
		this.setLocationRelativeTo(parent);

		this.setVisible(true);
	}

	private JButton makeDeleteButton() {
		JButton obrisi = new JButton("Obri\u0161i");

		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();

				if (index == -1) {
					JOptionPane.showMessageDialog(ListDialog.this, "Nije izabrana stavka za brisanje!", "Gre\u0161ka!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int choice = JOptionPane.showConfirmDialog(ListDialog.this,
						"Da li ste sigurni da \u017Eelite da potvrdite brisanje izabrane stavke?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION);

				if (choice == JOptionPane.YES_OPTION) {
					// ukloni vezu iz baze
					MainController.getInstance().removeXfromX(index);
					// ukloni iz view-a
					((DefaultListModel<Object>) list.getModel()).remove(index);

					JOptionPane.showMessageDialog(ListDialog.this, "Izabrana stavka je uspe\u0161no obrisana.",
							"Brisanje", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		return obrisi;
	}

	private JButton makeReturnButton() {
		JButton nazad = new JButton("Nazad");

		nazad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		return nazad;
	}

}
