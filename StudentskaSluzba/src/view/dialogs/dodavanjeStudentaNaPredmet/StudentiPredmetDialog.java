package view.dialogs.dodavanjeStudentaNaPredmet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import controller.MainController;
import model.Predmet;

/**
 * 
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiPredmetDialog extends JDialog {

	private static final long serialVersionUID = 9151390034160888249L;

	private JFrame parent;
	private JTextField search;
	private JTable table;
	private StudentFilter filterPoGodini;

	public StudentiPredmetDialog(JFrame parent) {
		super(parent, "Dodavanje studenta na predmet", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;

		this.makeItems();
	}

	private void makeItems() {
		this.makeTable();
		JScrollPane scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(Color.WHITE);

		JPanel top = this.makeTextField();
		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.add(Box.createHorizontalGlue());
		bottom.add(this.makeSaveChangesButton());
		bottom.add(Box.createHorizontalStrut(15));
		bottom.add(this.makeReturnButton());

		JPanel content = new JPanel(new BorderLayout(0, 30));
		content.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		content.add(top, BorderLayout.NORTH);
		content.add(scroll, BorderLayout.CENTER);
		content.add(bottom, BorderLayout.SOUTH);

		this.add(content, BorderLayout.CENTER);

	}

	private Component makeReturnButton() {
		JButton nazad = new JButton("Odustani");

		nazad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		return nazad;
	}

	private Component makeSaveChangesButton() {
		JButton izmeni = new JButton("Sa\u010Duvaj");
		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(StudentiPredmetDialog.this, "Izaberite studenta!", "Gre\u0161ka!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// metodi dodajStudentaNaPredmet prosledim index studenta
				MainController.getInstance().getPredmetiController()
						.dodajStudentaNaPredmet(table.convertRowIndexToModel(table.getSelectedRow()));
				dispose();
			}

		});

		return izmeni;
	}

	private JPanel makeTextField() {
		JLabel searchLabel = new JLabel("Pretra\u017Ei:");
		this.search = new JTextField();
		this.search.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				StudentiPredmetDialog.this.filterTable(search.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				StudentiPredmetDialog.this.filterTable(search.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

		});

		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		searchPanel.add(searchLabel);
		searchPanel.add(Box.createHorizontalStrut(15));
		searchPanel.add(this.search);

		return searchPanel;
	}

	@SuppressWarnings("unchecked")
	protected void filterTable(String text) {
		ArrayList<RowFilter<MiniStudentiTableModel, Integer>> filteri = new ArrayList<RowFilter<MiniStudentiTableModel, Integer>>();
		filteri.add(new StringContainsFilter(text));
		filteri.add(this.filterPoGodini);
		((TableRowSorter<MiniStudentiTableModel>) table.getRowSorter()).setRowFilter(RowFilter.andFilter(filteri));

	}

	private void makeTable() {
		MiniStudentiTableModel model = new MiniStudentiTableModel();
		TableRowSorter<MiniStudentiTableModel> rowSorter = new TableRowSorter<>(model);

		this.table = new JTable(model);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setRowHeight(25);
		table.setTableHeader(null);

		table.setRowSorter(rowSorter);

	}

	public void show(Predmet predmet) {
		this.search.setText("");

		this.filterPoGodini = new StudentFilter(predmet);
		@SuppressWarnings("unchecked")
		TableRowSorter<MiniStudentiTableModel> sorter = (TableRowSorter<MiniStudentiTableModel>) table.getRowSorter();
		sorter.setRowFilter(filterPoGodini);

		table.scrollRectToVisible(table.getCellRect(0, 0, false));
		table.clearSelection();

		Dimension d = parent.getSize();
		this.setSize(d.width / 3, d.height / 2);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}
}
