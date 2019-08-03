import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Color;
import javax.swing.border.BevelBorder;

/**
 * This is the implementation of ETERNITY: NUMBERS Calculator.
 * This is implemented as a Java Swing application.
 * 
 * The main tasks performed by this class are:
 * <ul>
 * <li>Takes inputs from user and generates output on screen.
 * <li>Generates Champernowne Constant (base 10).
 * <li>Calculates occurrences and position of a number in Champernowne constant.
 * <li>Performs basic calculations.
 * </ul>
 * @author Abhishek Rajput
 * @since 1.0.0
 *
 */
public class ChampernowneCalculator {
	

	private JFrame frmEternity;
	
	/**
	 * This static method calculates the digits of champernowne constant.
	 * 
	 * @param pos Position in Champernowne constant for which digit is to be calculated.
	 * @return Digit corresponding to the position
	 */
	public static int nextDigit(long pos) {
		int n = 1;
		long power = 1;	
		
		if(pos <= 0)
			return 0;
		
		pos--;
		
		for(;;n++) {
			 long block = power * (10-1) * n;
			 if(pos < block)
				 break;
			 pos = pos -block;
		        power = power*10;
		        
		}
		 long num = power + pos / n;
	    for (pos %= n; pos < n - 1; pos++) {
	        num /= 10;
	        
	    }
	    
	    return (int)(num % 10);
	   
	}

	/**
	 * Launch the application.
	 * 
	 * @param args Contains the supplied command-line arguments as an array of String objects
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChampernowneCalculator window = new ChampernowneCalculator();
					window.frmEternity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChampernowneCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEternity = new JFrame();
		frmEternity.setForeground(Color.BLACK);
		frmEternity.setFont(new Font("Dialog", Font.BOLD, 12));
		frmEternity.setTitle("CHAMPERNOWNE CALCULATOR");
		frmEternity.setBounds(100, 100, 747, 740);
		frmEternity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEternity.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 729, 446);
		frmEternity.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JTextArea textArea_output = new JTextArea();
		textArea_output.setFont(new Font("Monospaced", Font.BOLD, 15));		
		textArea_output.setBorder(BorderFactory.createEmptyBorder(1, 4, 1, 1));
		textArea_output.setEditable(false);
//		textArea_output.setBounds(10, 30, 708, 77);
//		panel.add(textArea_output);
		
		JLabel label_Number = new JLabel("");
		label_Number.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_Number.setBounds(66, 12, 46, 14);
		label_Number.setVisible(false);
		panel.add(label_Number);	
		
		
		JScrollPane scrollPane_output = new JScrollPane(textArea_output);
		scrollPane_output.setBounds(10, 30, 708, 77);
		panel.add(scrollPane_output);		
		
		
		JTextArea textArea_Input = new JTextArea();		
		textArea_Input.setFont(new Font("Monospaced", Font.BOLD, 15));
//		textArea_Input.setBounds(10, 137, 709, 57);
//		panel.add(textArea_Input);
		
		JScrollPane scrollPane_input = new JScrollPane(textArea_Input);
		scrollPane_input.setBounds(10, 137, 709, 57);
		panel.add(scrollPane_input);	
		
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(10, 11, 46, 14);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblOutput);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(10, 118, 46, 14);
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblInput);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("0");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 354, 114, 36);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		//btnNewButton.setOpaque(true);
		panel.add(btnNewButton);
		
		JButton button = new JButton(".");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append(".");
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(134, 354, 52, 36);
		panel.add(button);
		
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("+");
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(196, 354, 52, 36);
		panel.add(button_1);
		
		JButton button_2 = new JButton("1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("1");
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(10, 308, 52, 36);
		panel.add(button_2);
		
		JButton button_3 = new JButton("2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("2");
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(72, 308, 52, 36);
		panel.add(button_3);
		
		JButton button_4 = new JButton("3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("3");
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setBounds(134, 308, 52, 36);
		panel.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("-");
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBounds(196, 307, 52, 36);
		panel.add(button_5);
		
		JButton button_6 = new JButton("4");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("4");
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setBounds(10, 261, 52, 36);
		panel.add(button_6);
		
		JButton button_7 = new JButton("5");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("5");
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_7.setBackground(Color.LIGHT_GRAY);
		button_7.setBounds(72, 261, 52, 36);
		panel.add(button_7);
		
		JButton button_8 = new JButton("6");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("6");
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_8.setBackground(Color.LIGHT_GRAY);
		button_8.setBounds(134, 261, 52, 36);
		panel.add(button_8);
		
		JButton button_9 = new JButton("*");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("*");
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_9.setBackground(Color.LIGHT_GRAY);
		button_9.setBounds(196, 260, 52, 36);
		panel.add(button_9);
		
		JButton button_10 = new JButton("7");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("7");
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_10.setBackground(Color.LIGHT_GRAY);
		button_10.setBounds(10, 214, 52, 36);
		panel.add(button_10);
		
		JButton button_11 = new JButton("8");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("8");
			}
		});
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_11.setBackground(Color.LIGHT_GRAY);
		button_11.setBounds(72, 214, 52, 36);
		panel.add(button_11);
		
		JButton button_12 = new JButton("9");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("9");
			}
		});
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_12.setBackground(Color.LIGHT_GRAY);
		button_12.setBounds(134, 214, 52, 36);
		panel.add(button_12);
		
		JButton button_13 = new JButton("/");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.append("/");
			}
		});
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_13.setBackground(Color.LIGHT_GRAY);
		button_13.setBounds(196, 213, 52, 36);
		panel.add(button_13);
		
		JButton button_14 = new JButton("=");
		button_14.addActionListener(new ActionListener() {
			
			//performs basic calculations like addition, multiplication, subtraction and divison.			 
			public void actionPerformed(ActionEvent e) {
				String exp = textArea_Input.getText();
				if (exp.matches("[0-9.+]+[(*|+|-|-|/)][0-9.+]+") && exp.length() > 2) {
					
					try {
					String result = null;									
					
					if(exp.contains("*")){
					String[] splitted =  exp.split("\\*");
					if(exp.contains(".")) result = String.valueOf(Double.parseDouble(splitted[0]) * Double.parseDouble(splitted[1]));
					else result = String.valueOf(Integer.parseInt(splitted[0]) *Integer.parseInt(splitted[1]));
					 textArea_output.append("\nMultiplication: " + result);
					}
					
					else if (exp.contains("/")){
						String[] splitted =  exp.split("\\/");						 
						result = String.valueOf(Double.parseDouble(splitted[0]) / Double.parseDouble(splitted[1]));						
						textArea_output.append("\nDivision: " + result);
						}
					
					else if (exp.contains("+")){
						String[] splitted =  exp.split("\\+");					
						if(exp.contains(".")) result = String.valueOf(Double.parseDouble(splitted[0]) + Double.parseDouble(splitted[1]));
						else result = String.valueOf(Integer.parseInt(splitted[0]) + Integer.parseInt(splitted[1]));
						 textArea_output.append("\nSum: " + result);
						}
					
					else if (exp.contains("-")){
						String[] splitted =  exp.split("\\-");					
						if(exp.contains(".")) result = String.valueOf(Double.parseDouble(splitted[0]) - Double.parseDouble(splitted[1]));
						else result = String.valueOf(Integer.parseInt(splitted[0]) - Integer.parseInt(splitted[1]));
						 textArea_output.append("\nSubtraction: " + result);
						}
					}
					catch (Exception e4) {
						JOptionPane.showMessageDialog(null,"Please check your input.");
					}
					
				}
				else if (exp.matches("^[0-9.]+$") && exp.length() > 0)
					textArea_output.append("\n"+exp);
				else {
					JOptionPane.showMessageDialog(null,"Incorrect input format.");
				}
			}
		});
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_14.setBackground(Color.LIGHT_GRAY);
		button_14.setBounds(258, 308, 52, 82);
		panel.add(button_14);
		
		JButton button_15 = new JButton("\u2190");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
				if(textArea_Input.getText().length()> 0)
				textArea_Input.setText(textArea_Input.getText().substring(0, textArea_Input.getText().length()-1));
			}
				catch (Exception e5) {
					System.out.println("No input found");
				}
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_15.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		button_15.setBackground(Color.LIGHT_GRAY);
		button_15.setBounds(258, 261, 52, 36);
		panel.add(button_15);
		
		JButton btnC = new JButton("Clear Output");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_output.setText("");
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnC.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnC.setBackground(Color.LIGHT_GRAY);
		btnC.setBounds(320, 308, 114, 36);
		panel.add(btnC);	
		
		
		JButton btnGenerateNumber = new JButton("Generate Number");
		
		//generates Champernowne constant
		btnGenerateNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					String champConst = "0.";
					if(textArea_Input.getText().length() > 0 && !(textArea_Input.getText().matches("^[0]+$")) ) {
				int numberOfPlaces = Integer.parseInt(textArea_Input.getText());
				if(numberOfPlaces <= 200000) {
				for(int i = 1; i<= numberOfPlaces; i++) {
					champConst += nextDigit(i);
				}				
				
				textArea_output.setText(champConst);	
				label_Number.setText(champConst);
				}
				else JOptionPane.showMessageDialog(null,"Maximum limit for decimal places is 200000.\n Please enter number less than that.");
					}
					else JOptionPane.showMessageDialog(null,"Please enter a valid input.");
					}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Please check your input.");
				}
				
				
			}
		});
		btnGenerateNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGenerateNumber.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGenerateNumber.setBackground(Color.LIGHT_GRAY);
		btnGenerateNumber.setBounds(493, 261, 166, 36);
		panel.add(btnGenerateNumber);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = label_Number.getText();
				textArea_Input.append(num);
			}
		});
		btnRetrieve.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRetrieve.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRetrieve.setBackground(Color.LIGHT_GRAY);
		btnRetrieve.setBounds(320, 354, 114, 36);
		panel.add(btnRetrieve);
		
		JButton btnLocation = new JButton("First Position");
		
		//calculates postion of a number
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String num = label_Number.getText();
				if(num.length() >0) {
				String numToSearch = textArea_Input.getText();
				if (numToSearch.matches("[0-9]+")) {
					if(num.substring(1).indexOf(numToSearch) != -1) {
				textArea_output.append("\nFirst occurrence of number "+ numToSearch+" is at position: " + num.substring(1).indexOf(numToSearch));
					}
					else JOptionPane.showMessageDialog(null,"Requested number "+ numToSearch +" is not present!\n Try another number.");
				
				
				}
				else JOptionPane.showMessageDialog(null,"Please check your input.");
				}
				else JOptionPane.showMessageDialog(null,"Please generate number first.");
			}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Please check your input.");
				}
			}
		
		});
		btnLocation.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLocation.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLocation.setBackground(Color.LIGHT_GRAY);
		btnLocation.setBounds(493, 354, 166, 36);
		panel.add(btnLocation);
		
		JButton btnOccurrence = new JButton("Occurrence");
		
		//calculates occurrences of a number
		btnOccurrence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String num = label_Number.getText();
				if(num.length() >0) {
				String numToSearch = textArea_Input.getText();
				if (numToSearch.matches("[0-9]+")) {
		        int count = 0, fromIndex = 0;
		        
		        while ((fromIndex = num.substring(1).indexOf(numToSearch, fromIndex)) != -1 ){		 
		            		        	
		            count++;
		            fromIndex++;
			}
		        textArea_output.append("\nTotal occurrences of number "+ numToSearch+" : " + count);
				}
				else JOptionPane.showMessageDialog(null,"Please check your input.");
				}
				else JOptionPane.showMessageDialog(null,"Please generate number first.");
				}
				catch (Exception e3) {
					JOptionPane.showMessageDialog(null,"Please check your input.");
				}
			}
		});
		btnOccurrence.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnOccurrence.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOccurrence.setBackground(Color.LIGHT_GRAY);
		btnOccurrence.setBounds(493, 308, 166, 36);
		panel.add(btnOccurrence);		
		
		JButton btnClearInput = new JButton("Clear Input");
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Input.setText("");
			}
		});
		btnClearInput.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClearInput.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClearInput.setBackground(Color.LIGHT_GRAY);
		btnClearInput.setBounds(320, 260, 114, 36);
		panel.add(btnClearInput);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInstructions.setBounds(10, 421, 102, 14);
		panel.add(lblInstructions);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 444, 731, 240);
		frmEternity.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrToGenerate = new JTextArea();
		txtrToGenerate.setText("\n 1. To generate the Champernowne constant, enter the number of decimal places (max 200000) required, in the input field and press\r\n     'Generate Number' button.\r\n 2. To clear input field, press 'Clear Input' button.\r\n 3. To clear output screen, press 'Clear Output' button.\r\n 4. To calculate the first position of a number in generated constant, enter the number for which you want to find the position and press \r\n     'Position' button.\r\n 5. To calculate total occurrences of a number in generated constant,  enter the number for which you want to find the occurrences and \r\n     press 'Occurrence' button.\r\n 6. To perform basic calculations (only positive numbers), enter the first operand followed by operator and second operand and then \r\n      press '=' button.e.g. Enter 2+2 in the input field and press '='.\r\n 7. To paste the last generated Champernowne constant in the input field, press 'Retrieve' button.\r\n\r\n Note: Retrieve, First Position, and Occurrence functions will be executed on the last generated Champernowne constant.");
		txtrToGenerate.setBounds(0, 0, 731, 240);
		panel_1.add(txtrToGenerate);		
		
		
		
	}
}
