package com.concordia.soen6441project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayScreen {

	private JFrame frame;
	int turnCount=1;
	
public JFrame getFrame() {
		
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayScreen window = new PlayScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1295, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 13, 1253, 656);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(12, 13, 1229, 48);
		panel.add(panel_1);
		
		JLabel label = new JLabel("RISK GAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(503, 0, 234, 48);
		panel_1.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		//textArea.setBounds(12, 104, 275, 539);
		//panel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(12, 104, 275, 539);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Console");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 86, 111, 16);
		panel.add(lblNewLabel);
		
		
		//int turnCount=1;
		
		JList list_2 = new JList();
		JList list_1 = new JList();
		update(list_1,list_2,turnCount);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list_1.getSelectedIndex()==-1)
					list_1.setSelectedIndex(0);
				list_2.setListData(LoadGame.getGameModel().getadjacent(list_1.getSelectedValue().toString()).toArray());
			}
		});
		
		
		
		JList list_3 = new JList();
//		//JTextPane textPane_2 = new JTextPane();
//		Document doc1=textPane_2.getDocument();
//		JTextPane textPane_3 = new JTextPane();
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane(list_1);
		scrollPane_1.setBounds(340, 107, 227, 287);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane(list_2);
		scrollPane_2.setBounds(636, 107, 227, 287);
		panel.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane(list_3);
		scrollPane_3.setBounds(926, 107, 227, 287);
		panel.add(scrollPane_3);
		
		JLabel lblCountriesHeld = new JLabel("Countries Held");
		lblCountriesHeld.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCountriesHeld.setBounds(340, 87, 155, 16);
		panel.add(lblCountriesHeld);
		
		JLabel lblAdjacentCountries = new JLabel("Adjacent Countries");
		lblAdjacentCountries.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdjacentCountries.setBounds(636, 87, 190, 16);
		panel.add(lblAdjacentCountries);
		
		JButton btnNewButton = new JButton("Place Reinforcements");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(350, 417, 190, 34);
		panel.add(btnNewButton);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAttack.setBounds(646, 417, 190, 34);
		panel.add(btnAttack);
		
		JButton btnFortify = new JButton("Fortify");
		btnFortify.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFortify.setBounds(646, 478, 190, 34);
		panel.add(btnFortify);
		
		JButton btnEndTurn = new JButton("End turn");
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Player turn over "+ turnCount);
				turnCount++;
				if(turnCount<=LoadGame.getGameModel().getPlayers().size()) {
					update(list_1,list_2,turnCount);
				}
				else {
					turnCount=1;
					update(list_1,list_2,turnCount);
				}
				
				
			}
		});
		btnEndTurn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEndTurn.setBounds(646, 537, 190, 34);
		panel.add(btnEndTurn);
		
	}
	public void update(JList list_1,JList list_2,int turnCount) {
		
		ArrayList <Countries> xy=LoadGame.getGameModel().getHeldCountries(turnCount);
		ArrayList <String> yy=new ArrayList<String>();
		for (Countries countries : xy) {
			yy.add(countries.getName());
		}
		list_1.setListData(yy.toArray());
		list_1.setSelectedIndex(0);
		
	}
}
