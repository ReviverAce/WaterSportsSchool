package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import classes.Latawiec;
import classes.Maszt;
import enumy.Stan;
import enumy.Stopien;
import enumy.TypBom;
import enumy.TypMaszt;

public class AddMasztFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnZatwierdz;
	private JButton btnWr;
	private JTextField textField_3;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 * @param height 
	 * @param width 
	 * @param rectangle 
	 */
	public AddMasztFrame(int width, int height, int x1,int x2,int x3,int x4) {
		initComponents(width,height,x1,x2,x3,x4);
		createEvents();
	}

	private void initComponents(int width, int height, int x1,int x2,int x3,int x4) {
		// TODO Auto-generated method stub
		setTitle("Dodaj maszt");
		setPreferredSize(new Dimension(width+16,height+39));
		setMinimumSize(new Dimension(500,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x1,x2,x3,x4);
		setVisible(true);
		pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSystemZarzdzaniaSzko = new JLabel("Wprowadz dane dla nowego masztu",SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dane", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addComponent(lblSystemZarzdzaniaSzko, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSystemZarzdzaniaSzko)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Marka:");
		
		JLabel lblNewLabel_1 = new JLabel("Cena:");
		
		JLabel lblTelefon = new JLabel("Kategoria:");
		
		JLabel lblStawka = new JLabel("Długość:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		btnWr = new JButton("Wróć");
		
		btnZatwierdz = new JButton("Zatwierdz");
		
		JLabel lblNewLabel_2 = new JLabel("Typ:\r\n");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TypMaszt.values()));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnZatwierdz)
							.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
							.addComponent(btnWr))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTelefon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStawka, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 367, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTelefon)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStawka)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnWr)
						.addComponent(btnZatwierdz))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnWr.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TypSprzetFrame frame = new TypSprzetFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnZatwierdz.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = true;

				try {
					if (textField.getText().length() == 0) {
						throw new Exception();
					}
				} catch (Exception ex) {
					flag = false;
					JOptionPane.showMessageDialog(null, " Marka musi zawierać znaki");
				}

				try {
					if (!textField_1.getText().matches(".*\\d.*")) {
						throw new Exception();
					}
				} catch (Exception ex) {
					flag = false;
					JOptionPane.showMessageDialog(null, " Cena może zawierać tylko cyfry");
				}

				try {
					if (textField_2.getText().length() == 0) {
						throw new Exception();
					}
				} catch (Exception ex) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Kategoria musi zawierać znaki");
				}

				try {
					if (Integer.parseInt(textField_3.getText()) < 0) {
						throw new Exception();
					}
				} catch (Exception ex) {
					flag = false;
					JOptionPane.showMessageDialog(null, "Długość zawiera niedozwolone znaki lub jest mniejszy od zera");
				}
				
				TypMaszt type;
				if (comboBox.getSelectedIndex() == 0) {
					type = TypMaszt.RDM;
				} else {
					type = TypMaszt.SDM;
				}

				if (flag) {
					Maszt.dodajSprzet(textField.getText(), Stan.WOLNY, Integer.parseInt(textField_1.getText()), textField_2.getText(), Integer.parseInt(textField_3.getText()), type);
					JOptionPane.showMessageDialog(null, "Dodano maszt");

					SprzetFrame frame = new SprzetFrame(getContentPane().getSize().width,
							getContentPane().getSize().height, getContentPane().getBounds().x,
							getContentPane().getBounds().y, getContentPane().getBounds().width,
							getContentPane().getBounds().height);
					dispose();
				}
			}
		});
	}

}
