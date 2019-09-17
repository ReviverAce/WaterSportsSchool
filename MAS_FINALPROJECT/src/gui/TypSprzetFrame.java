package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class TypSprzetFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnWr;
	private JPanel panel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_2;
	private JButton btnagiel;
	private JButton btnMaszt;
	private JButton btnBom;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 * @param height 
	 * @param width 
	 * @param rectangle 
	 */
	public TypSprzetFrame(int width, int height, int x1,int x2,int x3,int x4) {
		initComponents(width,height,x1,x2,x3,x4);
		createEvents();
	}

	private void initComponents(int width, int height, int x1,int x2,int x3,int x4) {
		// TODO Auto-generated method stub
		setTitle("Typ Sprzętu");
		setPreferredSize(new Dimension(width+16,height+39));
		setMinimumSize(new Dimension(500,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x1,x2,x3,x4);
		setVisible(true);
		pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSystemZarzdzaniaSzko = new JLabel("Wybierz typ sprzętu jaki chcesz dodać\r\n",SwingConstants.CENTER);
		
		panel = new JPanel();
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnWr = new JButton("wróć");
		btnWr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnagiel = new JButton("Żagiel");
		panel_2.add(btnagiel);
		
		btnMaszt = new JButton("Maszt");
		panel_2.add(btnMaszt);
		
		btnBom = new JButton("Bom");
		panel_2.add(btnBom);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(btnWr, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnWr)
					.addContainerGap())
		);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("Wiosło");
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Pianka");
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Latawiec");
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Deska");
		panel_1.add(btnNewButton_3);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnWr.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WypozyczeniaFrame frame = new WypozyczeniaFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddWiosloFrame frame = new AddWiosloFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnNewButton_1.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPiankaFrame frame = new AddPiankaFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnNewButton_2.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddLatawiecFrame frame = new AddLatawiecFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnNewButton_3.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDeskaFrame frame = new AddDeskaFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnagiel.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddZagielFrame frame = new AddZagielFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnMaszt.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMasztFrame frame = new AddMasztFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		btnBom.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBomFrame frame = new AddBomFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
	}

}
