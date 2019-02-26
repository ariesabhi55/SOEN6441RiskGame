package com.concordia.soen6441project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame Hframe;
	UI ui=new UI();
	
	LoadGame lg=new LoadGame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.Hframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Hframe = new JFrame();
		Hframe.setBounds(100, 100, 713, 492);
		Hframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Hframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(12, 13, 671, 419);
		Hframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Map");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ui.getFrame().setVisible(true);;
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(166, 107, 319, 49);
		panel.add(btnNewButton);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lg.getFrame().setVisible(true);;
				
			}
		});
		btnLoadGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadGame.setBounds(166, 183, 319, 49);
		panel.add(btnLoadGame);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(12, 13, 647, 48);
		panel.add(panel_1);
		
		JLabel label = new JLabel("RISK GAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(233, 0, 234, 48);
		panel_1.add(label);
	}
}
