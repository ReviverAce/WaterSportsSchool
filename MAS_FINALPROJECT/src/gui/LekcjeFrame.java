package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.hibernate.Session;

import classes.Grupowa;
import classes.HibernateUtil;
import classes.Indywidualna;
import classes.Instruktor;
import classes.Klient;
import classes.Kursant;
import classes.Lekcja;
import classes.Osoba;
import classes.Wypozyczenie;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LekcjeFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnWr;
	private JScrollPane scrollPane;
	private JList lessonJList;
	private JLabel lessonInfoLabel;
	private JButton btnDodajNowOsob;
	private JButton btnUsu;
	private JButton btnZmie;
	private List lessonList;

	/**
	 * Create the frame.
	 * 
	 * @param height
	 * @param width
	 * @param rectangle
	 */
	public LekcjeFrame(int width, int height, int x1, int x2, int x3, int x4) {
		initComponents(width, height, x1, x2, x3, x4);
		createEvents();
	}

	private void initComponents(int width, int height, int x1, int x2, int x3, int x4) {
		// TODO Auto-generated method stub
		setTitle("Okno zarządzania lekcjami");
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
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lekcje",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Informacje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnDodajNowOsob = new JButton("Dodaj nową lekcje");

		btnUsu = new JButton("usuń");

		btnZmie = new JButton("zmień");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnDodajNowOsob)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUsu)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnZmie)
										.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
										.addComponent(btnWr)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnWr)
						.addComponent(btnDodajNowOsob).addComponent(btnUsu).addComponent(btnZmie))));

		lessonInfoLabel = new JLabel("");
		lessonInfoLabel.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(lessonInfoLabel, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_1.createSequentialGroup()
						.addComponent(lessonInfoLabel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addContainerGap()));

		lessonJList = new JList();
		scrollPane.setViewportView(lessonJList);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		// lewa strona-pobieram z bazy danych lekcje i umieszczam w liście
		DefaultListModel listaSprzet = new DefaultListModel();
		lessonList = Lekcja.listRecords();
		for (int i = 0; i < lessonList.size(); i++) {
			listaSprzet.addElement(lessonList.get(i));
		}
		lessonJList = new JList(listaSprzet);
		scrollPane.setViewportView(lessonJList);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}

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
				TypLekcjaFrame frame = new TypLekcjaFrame(getContentPane().getSize().width,
						getContentPane().getSize().height, getContentPane().getBounds().x,
						getContentPane().getBounds().y, getContentPane().getBounds().width,
						getContentPane().getBounds().height);
				dispose();
			}
		});

		// gdy klikniemy w element po lewej stronie
		lessonJList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int id = ((Lekcja) lessonList.get(lessonJList.getSelectedIndex())).getId();

				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Lekcja lesson = session.get(Lekcja.class, id);

				DefaultListModel listaLekcji = new DefaultListModel();

				// sprawdzam typ osoby i wyświetlam w lewym panelu dane o nim a w prawym
				// powiązania na jego temat
				// rightpersonlist to lista
				// JRighthlist to gui

				if (lesson instanceof Indywidualna) {
					lessonInfoLabel.setText("<html>typ: " + lesson.getClass().getSimpleName() + "<br/>Cena: "
							+ lesson.getCena() + "<br/>Spot: " + lesson.getSpot() + "<br/>Długość: "
							+ lesson.getTypLekcja() + "<br/>Instruktor: " + lesson.getInstruktor().getImie() + " "
							+ lesson.getInstruktor().getNazwisko() + "<br/>Kursanci: " + lesson.getKursant().getImie()
							+ " " + lesson.getKursant().getNazwisko() + "<html>");
				} else if (lesson instanceof Grupowa) {
					lessonInfoLabel.setText("<html>typ: " + lesson.getClass().getSimpleName() + "<br/>Cena: "
							+ lesson.getCena() + "<br/>Spot: " + lesson.getSpot() + "<br/>Długość: "
							+ lesson.getTypLekcja() + "<br/>Numer grupy: " + ((Grupowa) lesson).getNumer()
							+ "<br/>Rodzaj grupy: " + ((Grupowa) lesson).getRodzajGrupa() + "<br/>Instruktor: "
							+ lesson.getInstruktor().getImie() + " " + lesson.getInstruktor().getNazwisko()
							+ "<br/>Kursanci: " + lesson.getKursant().getImie() + " "
							+ lesson.getKursant().getNazwisko() + "<html>");
				}

				session.getTransaction().commit();
			}

		});

	}

}
