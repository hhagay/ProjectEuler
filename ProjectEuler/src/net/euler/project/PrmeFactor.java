package net.euler.project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PrmeFactor extends JFrame {

	private static PrmeFactor framePrmeFactor;
	private JPanel contentPane;
	private JTextField textFieldNumber;
	private JLabel lblMessage;
	private JButton btnBack;
	private MainPage mainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framePrmeFactor = new PrmeFactor();
					framePrmeFactor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrmeFactor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumber = new JLabel("Enter Number:");
		lblNumber.setBounds(41, 49, 95, 14);
		contentPane.add(lblNumber);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(146, 43, 140, 20);
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNumber.setText("");
				lblMessage.setText("Clear.");
			}
		});
		btnReset.setBounds(335, 215, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				//String str = "600851475143";
				String str=textFieldNumber.getText();
				Long lObj2 = Long.valueOf(str);
				//primeFactors(lObj2);
				
				//
				try{
					
					//public static List<Long> primeFactors long lObj2{
						List<Long> factors = new ArrayList<Long>();
						while (lObj2 % 2 == 0 && lObj2 > 0) {
							factors.add(2L);
							lObj2 /= 2;
							//System.out.println(factors);
						}

						for (long i = 3; i * i <= lObj2; i += 2) {
							while (lObj2 % i == 0) {
								factors.add(i);
								lObj2 /= i;
								//System.out.println(factors);
							}
						}
						if (lObj2 > 1)
							factors.add(lObj2);
						//System.out.println(factors);
						//System.out.println(lObj2);
						lblMessage.setText(Long.toString(lObj2));
						

						//return factors;
					//}
					
				}catch(Exception e){
					lblMessage.setText("Please enter valid numbers");
					
				}
			}
		}
	);
		btnGo.setBounds(236, 215, 89, 23);
		contentPane.add(btnGo);
		
		lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMessage.setBounds(41, 77, 271, 100);
		contentPane.add(lblMessage);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePrmeFactor.dispose();
				//mainPage.setVisible(true);
			}
		});
		btnBack.setBounds(335, 11, 89, 23);
		contentPane.add(btnBack);
	}

}
