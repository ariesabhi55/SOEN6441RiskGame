package com.concordia.soen6441project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.sql.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Date;
import java.sql.Timestamp;
import javax.swing.JList;
import javax.swing.JComboBox;

public class UI {

	private JFrame frame;
	private GameModel gm=new GameModel();
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
					UI window = new UI();
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
	public UI() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		BoardSetup bs=new BoardSetup();
		frame = new JFrame();
		frame.setBounds(100, 100, 1132, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("RISK GAME");
		
		Date date=new Date();
		long time=date.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println(ts);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(12, 13, 1090, 672);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 1066, 48);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRiskGame = new JLabel("RISK GAME");
		lblRiskGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiskGame.setBounds(434, 0, 234, 48);
		panel_1.add(lblRiskGame);
		lblRiskGame.setFont(new Font("Tahoma", Font.BOLD, 36));
		
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(22, 276, 854, 362);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		
		
		JLabel lblFileConfigurations = new JLabel("File Configurations");
		lblFileConfigurations.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFileConfigurations.setBounds(23, 236, 208, 27);
		panel.add(lblFileConfigurations);
		lblFileConfigurations.setVisible(false);
		

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(102, 135, 704, 397);
		
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel.add(fileChooser);
				
				int returnVal = fileChooser.showOpenDialog(frame);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            String fileName=file.getAbsolutePath();
		            try {
		            	
		            	FileReader reader=new FileReader(fileName);
		            	BufferedReader br=new BufferedReader(reader);
		            	textArea.read(br,null);
		            	br.close();
		            	textArea.requestFocus();
		            	scrollPane.setVisible(true);
		            	
		              // return the file path 
		            } catch (Exception ex) {
		              System.out.println("problem accessing file"+file.getAbsolutePath());
		            }
		        } 
		        else {
		            System.out.println("File access cancelled by user.");
		        }       
		    }   
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(22, 88, 126, 39);
		panel.add(btnNewButton);
		
		JButton btnNewGameFile = new JButton("New");
		btnNewGameFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				FileReader reader=new FileReader("C:\\Users\\Abhishek Rajput\\eclipse-workspace\\NewGameFile.txt");
            	BufferedReader br=new BufferedReader(reader);
            	textArea.read(br,null);
            	br.close();
            	textArea.requestFocus();
				
			    lblFileConfigurations.setVisible(true);
			    scrollPane.setVisible(true);
				}
				catch (Exception ex) {
		              System.out.println("problem accessing file");
		            }
			}
		});
		btnNewGameFile.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewGameFile.setBounds(22, 155, 126, 39);
		panel.add(btnNewGameFile);		
		
		JComboBox comboBoxAdjacent = new JComboBox();
		comboBoxAdjacent.setBounds(733, 96, 208, 27);
		panel.add(comboBoxAdjacent);
		
		
		JComboBox comboBoxMember = new JComboBox();
		comboBoxMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xy=comboBoxMember.getSelectedItem().toString();
				comboBoxAdjacent.setModel(new DefaultComboBoxModel(gm.getadjacent(xy).toArray()));
			}
		});
		comboBoxMember.setBounds(463, 96, 208, 27);
		panel.add(comboBoxMember);
		
		
		
		
		JComboBox comboBoxContinents = new JComboBox();
		comboBoxContinents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String xy=comboBoxContinents.getSelectedItem().toString();
				comboBoxMember.setModel(new DefaultComboBoxModel(gm.getMembers(xy).toArray()));
				
				xy=comboBoxMember.getSelectedItem().toString();
				comboBoxAdjacent.setModel(new DefaultComboBoxModel(gm.getadjacent(xy).toArray()));
			}
		});
		comboBoxContinents.setBounds(202, 96, 208, 27);
		panel.add(comboBoxContinents);
		//comboBoxContinents.setModel(new DefaultComboBoxModel(bs.getContinents().toArray()));
		//comboBoxContinents.add
		
		

		
		
		JButton btnStartGame = new JButton("Validate & Save");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gameData=textArea.getText();
				
				Boolean x=gm.initializeGame(gameData);
				if(!x) {
					JOptionPane.showMessageDialog(btnStartGame,"Error with Connected Graph","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					comboBoxContinents.setModel(new DefaultComboBoxModel(gm.getContinents().toArray()));
					String xy=comboBoxContinents.getSelectedItem().toString();
					comboBoxMember.setModel(new DefaultComboBoxModel(gm.getMembers(xy).toArray()));
					
					xy=comboBoxMember.getSelectedItem().toString();
					comboBoxAdjacent.setModel(new DefaultComboBoxModel(gm.getadjacent(xy).toArray()));
					int year=1900+date.getYear();
					int month=date.getMonth()+1;
					File fileName= new File("C:\\Map\\"+year+"-"+month+"-"+date.getDate()+" "+date.getHours()+date.getMinutes()+date.getSeconds()+".txt");
					System.out.println(fileName.getAbsolutePath());

					try {
			           
			            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			            textArea.write(outFile);

			            outFile.close();
					}
					 catch (IOException ex) {
				        }
				}
				
				
		        }
			
		});
		
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStartGame.setBounds(888, 599, 178, 39);
		panel.add(btnStartGame);
		
		JLabel lblNewLabel = new JLabel("Continents");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(202, 74, 103, 16);
		panel.add(lblNewLabel);
		
		JLabel lblMemberCountries = new JLabel("Member Countries");
		lblMemberCountries.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMemberCountries.setBounds(463, 74, 141, 16);
		panel.add(lblMemberCountries);
		
		JLabel lblAdjacentCountries = new JLabel("Adjacent Countries");
		lblAdjacentCountries.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdjacentCountries.setBounds(735, 75, 141, 16);
		panel.add(lblAdjacentCountries);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String gameData=textArea.getText();
				Boolean x=gm.initializeGame(gameData);
				if(!x) {
					JOptionPane.showMessageDialog(btnStartGame,"Error with Connected Graph","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnValidate.setBounds(888, 527, 178, 39);
		panel.add(btnValidate);
		}
		
		public GameModel getGameModel() {
			return gm;
		}
	}

