package com.concordia.soen6441project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadGame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static GameModel gm=new GameModel();
	
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
					LoadGame window = new LoadGame();
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
	public LoadGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 874, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, -22, 832, 591);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 808, 48);
		panel_1.setLayout(null);
		panel.add(panel_1);
		
		JLabel label = new JLabel("RISK GAME");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 36));
		label.setBounds(233, 0, 234, 48);
		panel_1.add(label);
		JLabel lblNewLabel = new JLabel("Player 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(65, 202, 111, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(159, 194, 254, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player 2:");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayer.setBounds(65, 259, 111, 16);
		panel.add(lblPlayer);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(159, 251, 254, 34);
		panel.add(textField_1);
		
		JLabel lblPlayer_1 = new JLabel("Player 3:");
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayer_1.setBounds(65, 314, 111, 16);
		panel.add(lblPlayer_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(159, 306, 254, 34);
		panel.add(textField_2);
		
		JLabel lblPlayer_2 = new JLabel("Player 4:");
		lblPlayer_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayer_2.setBounds(65, 368, 111, 16);
		panel.add(lblPlayer_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(159, 360, 254, 34);
		panel.add(textField_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(524, 200, 203, 34);
		comboBox_1.setModel(new DefaultComboBoxModel(new GameModel().readDirectory().toArray()));
		panel.add(comboBox_1);
		comboBox_1.setVisible(false );
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(644, 486, 163, 25);
		panel.add(btnLoadGame);
		btnLoadGame.setVisible(false);
		
		JButton btnNewButton = new JButton("Select Game File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setVisible(true);
				btnLoadGame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(524, 101, 203, 65);
		panel.add(btnNewButton);
		
		JLabel lblPlayer_3 = new JLabel("Player 5:");
		lblPlayer_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayer_3.setBounds(65, 427, 111, 16);
		panel.add(lblPlayer_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(159, 419, 254, 34);
		panel.add(textField_4);
		
		JLabel lblPlayer_4 = new JLabel("Player 6:");
		lblPlayer_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayer_4.setBounds(65, 485, 111, 16);
		panel.add(lblPlayer_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(159, 477, 254, 34);
		panel.add(textField_5);
		
		String[] items = new String[] {"Two", "Three", "Four", "Five","Six"};
		JComboBox comboBox = new JComboBox(items);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String xy=comboBox.getSelectedItem().toString();
				reloadPlayers(xy, lblNewLabel, lblPlayer, lblPlayer_1, lblPlayer_2, lblPlayer_3, lblPlayer_4);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(58, 101, 216, 22);
		String xy=comboBox.getSelectedItem().toString();
		panel.add(comboBox);
		reloadPlayers(xy,lblNewLabel,lblPlayer,lblPlayer_1,lblPlayer_2,lblPlayer_3,lblPlayer_4);
	
		
		
		JLabel lblSelectNoOf = new JLabel("Select no. of Players");
		lblSelectNoOf.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectNoOf.setBounds(65, 74, 177, 29);
		panel.add(lblSelectNoOf);
		
		
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName="C:\\Map\\"+comboBox_1.getSelectedItem().toString();
				//File selectedFile= new File(fileName);
				try {
					BufferedReader reader= new BufferedReader(new FileReader(fileName));
					StringBuilder stringBuilder = new StringBuilder();
					String line;
					String input;
					boolean flag;
					while((line = reader.readLine()) != null) {
						stringBuilder.append(line);
						if(line!=null)
							stringBuilder.append("\n");
					}
					input = stringBuilder.toString();
					//GameModel gm=new GameModel();
					flag= gm.initializeGame(input);
					if(flag==true) {
						String xy=comboBox.getSelectedItem().toString();
						System.out.println(xy);
						ArrayList<String> players=getData(xy);
						for (String string : players) {
							System.out.println(string);
						}
						gm.createPlayers(players);
						PlayScreen ps=new PlayScreen();
						ps.getFrame().setVisible(true);
						
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
	}
	public void reloadPlayers(String xy,JLabel lblNewLabel,JLabel lblPlayer,JLabel lblPlayer_1,JLabel lblPlayer_2,JLabel lblPlayer_3,JLabel lblPlayer_4) {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		if(xy.equals("Two")) {
			lblNewLabel.setVisible(true);
			lblPlayer.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			lblPlayer_1.setVisible(false);
			lblPlayer_2.setVisible(false);
			textField_2.setVisible(false);
			textField_3.setVisible(false);
			lblPlayer_3.setVisible(false);
			lblPlayer_4.setVisible(false);
			textField_4.setVisible(false);
			textField_5.setVisible(false);
		}
		else if(xy.equals("Three")){
			lblNewLabel.setVisible(true);
			lblPlayer.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			lblPlayer_1.setVisible(true);
			lblPlayer_2.setVisible(false);
			textField_2.setVisible(true);
			textField_3.setVisible(false);
			lblPlayer_3.setVisible(false);
			lblPlayer_4.setVisible(false);
			textField_4.setVisible(false);
			textField_5.setVisible(false);
		}
		else if(xy.equals("Four")){
			lblNewLabel.setVisible(true);
			lblPlayer.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			lblPlayer_1.setVisible(true);
			lblPlayer_2.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			lblPlayer_3.setVisible(false);
			lblPlayer_4.setVisible(false);
			textField_4.setVisible(false);
			textField_5.setVisible(false);
		}
		else if(xy.equals("Five")){
			lblNewLabel.setVisible(true);
			lblPlayer.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			lblPlayer_1.setVisible(true);
			lblPlayer_2.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			lblPlayer_3.setVisible(true);
			lblPlayer_4.setVisible(false);
			textField_4.setVisible(true);
			textField_5.setVisible(false);
		}
		else if(xy.equals("Six")){
			lblNewLabel.setVisible(true);
			lblPlayer.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			lblPlayer_1.setVisible(true);
			lblPlayer_2.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			lblPlayer_3.setVisible(true);
			lblPlayer_4.setVisible(true);
			textField_4.setVisible(true);
			textField_5.setVisible(true);
		}
	}
	public ArrayList<String> getData(String xy) {
		ArrayList<String> playerName=new ArrayList<String>();
		if(xy.equals("Two")) {
			if(textField.getText().trim().equals("")||textField_1.getText().trim().equals(""))
				System.out.println("Please Enter Names for all players");
			else {
			playerName.add(textField.getText());
			playerName.add(textField_1.getText());
			}
			
		}
		else if(xy.equals("Three")){
			if(textField.getText().trim().equals("")||textField_1.getText().trim().equals("")||textField_2.getText().trim().equals(""))
				System.out.println("Please Enter Names for all players");
			else {
			playerName.add(textField.getText());
			playerName.add(textField_1.getText());
			playerName.add(textField_2.getText());
			}
		}
		else if(xy.equals("Four")){
			if(textField.getText().trim().equals("")||textField_1.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals(""))
				System.out.println("Please Enter Names for all players");
			else {
			playerName.add(textField.getText());
			playerName.add(textField_1.getText());
			playerName.add(textField_2.getText());
			playerName.add(textField_3.getText());
			}
		}
		else if(xy.equals("Five")){
			if(textField.getText().trim().equals("")||textField_1.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals("")||textField_4.getText().trim().equals(""))
				System.out.println("Please Enter Names for all players");
			else {
			playerName.add(textField.getText());
			playerName.add(textField_1.getText());
			playerName.add(textField_2.getText());
			playerName.add(textField_3.getText());
			playerName.add(textField_4.getText());
			}
		}
		else if(xy.equals("Six")){
			if(textField.getText().trim().equals("")||textField_1.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals("")||textField_4.getText().trim().equals("")||textField_5.getText().trim().equals(""))
				System.out.println("Please Enter Names for all players");
			else {
			playerName.add(textField.getText());
			playerName.add(textField_1.getText());
			playerName.add(textField_2.getText());
			playerName.add(textField_3.getText());
			playerName.add(textField_4.getText());
			playerName.add(textField_5.getText());
			}
		}
		return playerName;
	}
	public static GameModel getGameModel() {
		return gm;
	}
}
