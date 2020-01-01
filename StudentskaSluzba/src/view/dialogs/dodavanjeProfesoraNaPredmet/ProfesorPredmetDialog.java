/**
 * 
 */
package view.dialogs.dodavanjeProfesoraNaPredmet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesorPredmetDialog extends JDialog {

	private static final long serialVersionUID = 2997158548237242617L;

	private JFrame parent;
	private JTextField search;
	private JTable table;

	/**
	 * @param parent
	 */
	public ProfesorPredmetDialog(JFrame parent) {
		super(parent, "Izbor profesora na predmetu", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;

		int minwidth = this.makeItems();

		this.setMinimumSize(new Dimension(minwidth, 0));
	}

	private int makeItems() {
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
		return content.getMinimumSize().width + 18;
	}

	private void makeTable() {
		MiniProfesoriTableModel model = new MiniProfesoriTableModel();
		TableRowSorter<MiniProfesoriTableModel> rowSorter = new TableRowSorter<>(model);

		this.table = new JTable(model);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setRowHeight(25);
		table.setTableHeader(null);

		table.setRowSorter(rowSorter);
	}

	private JPanel makeTextField() {
		JLabel searchLabel = new JLabel("Pretra\u017Ei:");
		this.search = new JTextField();

		this.search.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				ProfesorPredmetDialog.this.filterTable(search.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				ProfesorPredmetDialog.this.filterTable(search.getText());
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
	private void filterTable(String s) {
		RowFilter<MiniProfesoriTableModel, Integer> filter = new StringContainsFilter(s);
		((TableRowSorter<MiniProfesoriTableModel>) table.getRowSorter()).setRowFilter(filter);
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

	private JButton makeSaveChangesButton() {
		JButton izmeni = new JButton("Sa\u010Duvaj");
		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(ProfesorPredmetDialog.this, "Izaberite profesora!", "Gre\u0161ka!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				MainController.getInstance().getPredmetiController()
						.izmeniProfesoraNaPredmetu(table.convertRowIndexToModel(table.getSelectedRow()));
				dispose();
			}

		});

		return izmeni;
	}

	public void show(int index) {
		this.search.setText("");

		((TableRowSorter<?>) table.getRowSorter()).setRowFilter(null);
		try {
			int viewIndex = table.convertRowIndexToView(index);
			table.setRowSelectionInterval(viewIndex, viewIndex);
			table.scrollRectToVisible(table.getCellRect(table.getSelectedRow(), 0, false));
		} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
			table.clearSelection();
			table.scrollRectToVisible(table.getCellRect(0, 0, false));
		}

		Dimension d = parent.getSize();
		this.setSize(d.width / 4, d.height / 2);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

}
