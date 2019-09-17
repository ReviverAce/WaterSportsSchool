package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import org.hibernate.Session;

import classes.Grupowa;
import classes.HibernateUtil;
import classes.Instruktor;
import classes.Klient;
import classes.Kursant;
import classes.Lekcja;
import classes.Osoba;
import classes.Wypozyczenie;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class OsobaFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnWr;
	private JScrollPane scrollPane;
	private JList JLeftList;
	private JScrollPane scrollPane_1;
	private JList JRightList;
	private JLabel lblNewLabel;
	private JButton btnDodajNowOsob;
	private JButton btnUsu;
	private JButton btnZmie;
	private JLabel lblNewLabel_1;
	private List leftPersonList;
	private List rightPersonList;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private String klasaPrawejListy;

	/**
	 * Create the frame.
	 * 
	 * @param height
	 * @param width
	 * @param rectangle
	 */
	public OsobaFrame(int width, int height, int x1, int x2, int x3, int x4) {
		initComponents(width, height, x1, x2, x3, x4);
		createEvents();
	}

	// utworzenie gui

	private void initComponents(int width, int height, int x1, int x2, int x3, int x4) {
		// TODO Auto-generated method stub
		setTitle("Okno zarządzania osobą");
		setPreferredSize(new Dimension(width + 16, height + 39));
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x1, x2, x3, x4);
		setVisible(true);
		pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btnWr = new JButton("Wróć");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Osoby", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dane", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		btnDodajNowOsob = new JButton("Dodaj nową osobę");

		btnUsu = new JButton("usuń");

		btnZmie = new JButton("zmień");

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dane osoby:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Dane osoby:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 221, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 156, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(panel, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
												.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 221,
																Short.MAX_VALUE)
														.addGap(6))
												.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnDodajNowOsob)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUsu)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnZmie)
										.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
										.addComponent(btnWr)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnWr)
								.addComponent(btnDodajNowOsob).addComponent(btnUsu).addComponent(btnZmie))));

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		scrollPane_1 = new JScrollPane();

		lblNewLabel = new JLabel((String) null);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE).addContainerGap()));

		JRightList = new JList();
		scrollPane_1.setViewportView(JRightList);
		panel_1.setLayout(gl_panel_1);

		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addContainerGap()));

		// lewa strona-pobieram z bazy danych osoby i umieszczam w liście
		DefaultListModel listaOsob = new DefaultListModel();
		leftPersonList = Osoba.listPersons();
		for (int i = 0; i < leftPersonList.size(); i++) {
			listaOsob.addElement(leftPersonList.get(i));
		}
		JLeftList = new JList(listaOsob);
		scrollPane.setViewportView(JLeftList);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}

	// eventy

	private void createEvents() {
		// TODO Auto-generated method stub

		btnWr.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu(getContentPane().getSize().width, getContentPane().getSize().height,
						getContentPane().getBounds().x, getContentPane().getBounds().y,
						getContentPane().getBounds().width, getContentPane().getBounds().height);
				dispose();
			}
		});

		btnDodajNowOsob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypOsobaFrame frame = new TypOsobaFrame(getContentPane().getSize().width,
						getContentPane().getSize().height, getContentPane().getBounds().x,
						getContentPane().getBounds().y, getContentPane().getBounds().width,
						getContentPane().getBounds().height);
				dispose();
			}
		});

		// gdy klikniemy w element po lewej stronie
		JLeftList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int id = ((Osoba) leftPersonList.get(JLeftList.getSelectedIndex())).getId();

				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Osoba osoba = session.get(Osoba.class, id);

				DefaultListModel listaOsob = new DefaultListModel();

				// sprawdzam typ osoby i wyświetlam w lewym panelu dane o nim a w prawym
				// powiązania na jego temat
				// rightpersonlist to lista
				// JRighthlist to gui

				if (osoba instanceof Kursant) {

					rightPersonList = ((Kursant) osoba).getLekcja();
					for (int i = 0; i < rightPersonList.size(); i++) {
						listaOsob.addElement(rightPersonList.get(i));
					}
					JRightList.setModel(listaOsob);
					lblNewLabel.setText("Informacje o lekcjach kursanta");
					lblNewLabel_1.setText("<html>Imie: " + osoba.getImie() + "<br/>Nazwisko: " + osoba.getNazwisko()
							+ "<br/>Telefon: " + osoba.getTelefon() + "<br/>Instruktor: "
							+ ((Kursant) osoba).getInstruktor().getImie() + " "
							+ ((Kursant) osoba).getInstruktor().getNazwisko() + "<html>");
					klasaPrawejListy = "Kursant";
					panel_3.setBorder(
							new TitledBorder(null, "Dane lekcji:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					lblNewLabel_2.setText("");

				} else if (osoba instanceof Instruktor) {

					rightPersonList = ((Instruktor) osoba).getKursanci();
					for (int i = 0; i < rightPersonList.size(); i++) {
						listaOsob.addElement(rightPersonList.get(i));
					}
					JRightList.setModel(listaOsob);
					lblNewLabel.setText("Informacje o kursantach instruktora");
					lblNewLabel_1.setText("<html>Imie: " + osoba.getImie() + "<br/>Nazwisko: " + osoba.getNazwisko()
							+ "<br/>Telefon: " + osoba.getTelefon() + "<br/>Stawka: " + ((Instruktor) osoba).getStawka()
							+ "<br/>Stopień: " + ((Instruktor) osoba).getStopien() + "<html>");
					klasaPrawejListy = "Instruktor";
					panel_3.setBorder(new TitledBorder(null, "Dane kursanta:", TitledBorder.LEADING, TitledBorder.TOP,
							null, null));
					lblNewLabel_2.setText("");

				} else if (osoba instanceof Klient) {

					rightPersonList = ((Klient) osoba).getWypozyczenie();
					for (int i = 0; i < rightPersonList.size(); i++) {
						listaOsob.addElement(rightPersonList.get(i));
					}
					JRightList.setModel(listaOsob);
					lblNewLabel.setText("Informacje o wypożyczeniach klienta");
					lblNewLabel_1.setText("<html>Imie: " + osoba.getImie() + "<br/>Nazwisko: " + osoba.getNazwisko()
							+ "<br/>Telefon: " + osoba.getTelefon() + "<br/>Ile zapłacono: "
							+ ((Klient) osoba).getIleZaplacono() + "<html>");
					klasaPrawejListy = "Klient";
					panel_3.setBorder(new TitledBorder(null, "Dane wypożyczenia:", TitledBorder.LEADING,
							TitledBorder.TOP, null, null));
					lblNewLabel_2.setText("");

				}
				session.getTransaction().commit();
			}

		});

		// gdy klikniemy w element po prawej stronie
		JRightList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (klasaPrawejListy.equals("Kursant")) {

					Lekcja lekcja = (Lekcja) rightPersonList.get(JRightList.getSelectedIndex());

					if (lekcja.getClass().getSimpleName().equals("Indywidualna")) {
						lblNewLabel_2.setText("<html>typ: " + lekcja.getClass().getSimpleName() + "<br/>Cena: "
								+ lekcja.getCena() + "<br/>Spot: " + lekcja.getSpot() + "<br/>Długość: "
								+ lekcja.getTypLekcja() + "<br/>Instruktor: " + lekcja.getInstruktor().getImie() + " "
								+ lekcja.getInstruktor().getNazwisko() + "<html>");
					} else {
						lblNewLabel_2.setText("<html>typ: " + lekcja.getClass().getSimpleName() + "<br/>Cena: "
								+ lekcja.getCena() + "<br/>Spot: " + lekcja.getSpot() + "<br/>Długość: "
								+ lekcja.getTypLekcja() + "<br/>Numer grupy: " + ((Grupowa) lekcja).getNumer()
								+ "<br/>Rodzaj grupy: " + ((Grupowa) lekcja).getRodzajGrupa() + "<br/>Instruktor: "
								+ lekcja.getInstruktor().getImie() + " " + lekcja.getInstruktor().getNazwisko()
								+ "<html>");
					}

				} else if (klasaPrawejListy.equals("Instruktor")) {

					Kursant kursant = ((Kursant) rightPersonList.get(JRightList.getSelectedIndex()));

					lblNewLabel_2.setText("<html>Imie: " + kursant.getImie() + "<br/>Nazwisko: " + kursant.getNazwisko()
							+ "<br/>Telefon: " + kursant.getTelefon() + "<html>");

				} else if (klasaPrawejListy.equals("Klient")) {

					Wypozyczenie wypozyczenie = ((Wypozyczenie) rightPersonList.get(JRightList.getSelectedIndex()));

					String zwrot;
					if (wypozyczenie.getDataZwrotu() != null) {
						zwrot = wypozyczenie.getDataZwrotu().toString();
					} else {
						zwrot = "brak";
					}

					lblNewLabel_2.setText("<html>Data wypożyczenia: " + wypozyczenie.getDataWypozyczenia()
							+ "<br/>Data zwrotu: " + zwrot + "<br/>Na ile: " + wypozyczenie.getNaIle() + "<br/>Sprzęt: "
							+ wypozyczenie.getSprzet().getClass().getSimpleName() + " "
							+ wypozyczenie.getSprzet().getMarka() + " " + wypozyczenie.getSprzet().getKategoria()
							+ "<br/>Cena: " + wypozyczenie.getSprzet().getCena() + "<html>");

				}

			}
		});

	}
}
