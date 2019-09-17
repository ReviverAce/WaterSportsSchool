package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton osoba;
	private JButton sprzet;
	private JButton lekcje;
	private JButton wypozyczenia;

	/**
	 * Create the frame.
	 * @param height 
	 * @param width 
	 * @param rectangle 
	 */
	public Menu(int width, int height, int x1,int x2,int x3,int x4) {
		initComponents(width,height,x1,x2,x3,x4);
		createEvents();
	}

	private void initComponents(int width, int height, int x1,int x2,int x3,int x4) {
		// TODO Auto-generated method stub
		setTitle("Menu główne");
		setPreferredSize(new Dimension(width+16,height+39));
		setMinimumSize(new Dimension(500,400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x1,x2,x3,x4);
		setVisible(true);
		pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSystemZarzdzaniaSzko = new JLabel("System zarządzania szkołą sportów wodnych",SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		osoba = new JButton("Zarządzaj osobami");
		
		sprzet = new JButton("Zarządzaj sprzętem");
		
		wypozyczenia = new JButton("Wypożyczenia");
		
		lekcje = new JButton("Lekcje");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(166)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lekcje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(osoba, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
						.addComponent(sprzet, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(wypozyczenia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(141))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(osoba)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sprzet)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(wypozyczenia)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lekcje)
					.addGap(40))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
		osoba.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OsobaFrame frame = new OsobaFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		sprzet.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SprzetFrame frame = new SprzetFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		lekcje.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LekcjeFrame frame = new LekcjeFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
		wypozyczenia.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WypozyczeniaFrame frame = new WypozyczeniaFrame(getContentPane().getSize().width,getContentPane().getSize().height,getContentPane().getBounds().x,getContentPane().getBounds().y,getContentPane().getBounds().width,getContentPane().getBounds().height);
				dispose();
			}
		});
		
	}

}
