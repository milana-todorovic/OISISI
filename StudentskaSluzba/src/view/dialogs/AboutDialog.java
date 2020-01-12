/**
 * 
 */
package view.dialogs;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.MainFrame;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class AboutDialog extends JDialog {

	private static final long serialVersionUID = -3323967826780567463L;

	public AboutDialog() {
		super(MainFrame.getInstance());

		this.setTitle("Opis");

		ImageIcon imgIc = new ImageIcon("resource/ana.png");
		JLabel jlep1 = new JLabel(imgIc);

		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);
		jep.setContentType("text/html");
		jep.setText("<html>\r\n" + "<body>\r\n" + "\r\n" + "<h2 align = \"center\">Ana Peri\u0161i\u0107</h2>\r\n"
				+ "\r\n" + "<div align = \"center\"> <> </div>\r\n"
				+ "<div align = \"center\"> <i>O autoru</i> <hr> </div>\r\n"
				+ "<div align = \"center\"> <p> Ro\u0111ena 12.09.1998 u Trebinju, Republika Srpska (Bosna i Hercegovina). Poha\u0111ala i zavr\u0161ila Osnovnu \u0161kolu \"Jovan Jovanovi\u0107 Zmaj\" u Trebinju, nakon \u010Dega upisuje Srednju \u0161kolu \"Jovan Du\u010Di\u0107\" i zavr\u0161ava 2017-te. Nakon toga upisuje osnovne akademske studije na <b>Fakultetu tehni\u010Dkih nauka</b> u Novom Sadu, smer <b>Ra\u010Dunarstvo i automatika</b> i usko se opredeljuje u tre\u0107oj godini na <b>Primenjene ra\u010Dunarske nauke</b>. </p> </div>\r\n"
				+ "<div align = \"center\"> <br> <i>O aplikaciji</i> <hr> </div>\r\n" + "\r\n"
				+ "<div align = \"center\"> <p> Aktuelna aplikacija koju koristite je trenutno <b>verzije v1.0</b>. Namena aplikacije je da omogu\u0107i efektivniji rad zaposlenima na studentskoj slu\u017Ebi.</p> </div>\r\n"
				+ "\r\n" + "</body>\r\n" + "</html>");
		jep.setCaretPosition(0);

		ImageIcon imgIc1 = new ImageIcon("resource/lana.png");
		JLabel jlep2 = new JLabel(imgIc1);

		JEditorPane jep1 = new JEditorPane();
		jep1.setEditable(false);
		jep1.setContentType("text/html");
		jep1.setText("<html>\r\n" + "<body>\r\n" + "\r\n" + "<h2 align = \"center\">Milana Todorovi\u0107</h2>\r\n"
				+ "\r\n" + "<div align = \"center\"> <> </div>\r\n"
				+ "<div align = \"center\"> <i>O autoru</i> <hr> </div>\r\n"
				+ "<div align = \"center\"> <p>  Ro\u0111ena 27.11.1998 u Mili\u0107ima, Republika Srpska (Bosna i Hercegovina). Poha\u0111ala i zavr\u0161ila Osnovnu \u0161kolu \"Aleksa Jak\u0161i\u0107\" u  Mili\u0107ima, nakon \u010Dega upisuje Srednju \u0161kolu \"Milutin Milankovi\u0107\" i zavr\u0161ava 2017-te. Nakon toga upisuje osnovne akademske studije na <b>Fakultetu tehni\u010Dkih nauka</b> u Novom Sadu, smer <b>Ra\u010Dunarstvo i automatika</b> i usko se opredeljuje u tre\u0107oj godini na <b>Primenjene ra\u010Dunarske nauke</b>. </p> </div>\r\n"
				+ "<div align = \"center\"> <br> <i>O aplikaciji</i> <hr> </div>\r\n" + "\r\n"
				+ "<div align = \"center\"> <p> Aktuelna aplikacija koju koristite je trenutno <b>verzije v1.0</b>. Namena aplikacije je da omogu\u0107i efektivniji rad zaposlenima na studentskoj slu\u017Ebi. <br><br><br> </p> </div>\r\n"
				+ "\r\n" + "</body>\r\n" + "</html>");
		jep1.setCaretPosition(0);

		JScrollPane scroll = new JScrollPane(jep);
		JPanel content = new JPanel(new BorderLayout());
		content.add(jlep1, BorderLayout.NORTH);
		content.add(scroll, BorderLayout.CENTER);

		JScrollPane scroll1 = new JScrollPane(jep1);
		JPanel content1 = new JPanel(new BorderLayout());
		content1.add(jlep2, BorderLayout.NORTH);
		content1.add(scroll1, BorderLayout.CENTER);

		JTabbedPane tabs = new JTabbedPane();

		tabs.addTab("Student 1", content);
		tabs.addTab("Student 2", content1);

		this.add(tabs);
		this.setSize(800, 600);
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setVisible(true);
	}

}
