package net.euler.project;


import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SumNumbers extends JFrame {

	private JPanel contentPane;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JLabel lblNum3;
	private JLabel lblAnswer;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textFieldAnswer;
	private JLabel lblMessageCenter;
	private JButton btnBack;
	private JButton btnClear;
	private JButton btnCalculate;
	private static SumNumbers frameSum;
	private MainPage mainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameSum = new SumNumbers();
					frameSum.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SumNumbers() {
		setTitle("Sum Multiples");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		lblNum1 = new JLabel("Num 1:");
		lblNum1.setBounds(10, 23, 46, 14);
		contentPane.add(lblNum1);
		
		lblNum2 = new JLabel("Num 2:");
		lblNum2.setBounds(10, 60, 46, 14);
		contentPane.add(lblNum2);
		
		lblNum3 = new JLabel("Limit:");
		lblNum3.setBounds(10, 102, 46, 14);
		contentPane.add(lblNum3);
		
		textField1 = new JTextField();
		textField1.setBounds(77, 23, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(77, 60, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(77, 102, 86, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				int totalNums=0;
				int counter, num1, num2, numLimit;
				try{
					// read user input
					num1=Integer.parseInt(textField1.getText());
					num2=Integer.parseInt(textField2.getText());
					numLimit=Integer.parseInt(textField3.getText());
					
					// perform calculation
					for ( counter = 0; counter < numLimit; counter++) {
						if ((counter%num1 == 0)||(counter%num2 == 0)) {
							totalNums = totalNums + counter;
							textFieldAnswer.setText(Integer.toString(totalNums));
						}
					}
				}catch (Exception eadd){
					//JOptionPane.showMessageDialog(null, "Please enter valid numbers");
					lblMessageCenter.setText("Please enter valid numbers");
				}
			}
		});
		btnCalculate.setBounds(10, 208, 89, 23);
		contentPane.add(btnCalculate);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textFieldAnswer.setText("");
				lblMessageCenter.setText("Cleared: Try again");
			}
		});
		btnClear.setBounds(119, 208, 89, 23);
		contentPane.add(btnClear);
		
		lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(10, 147, 65, 14);
		contentPane.add(lblAnswer);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnswer.setBounds(77, 133, 86, 64);
		contentPane.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		lblMessageCenter = new JLabel("Message Center");
		lblMessageCenter.setBounds(259, 23, 165, 109);
		contentPane.add(lblMessageCenter);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					frameSum = new SumNumbers();
					frameSum.setVisible(true);
					frameSum.dispose();
					mainPage = new MainPage();
					//mainPage.setVisible(true);
				}catch(Exception eback){
					eback.printStackTrace();
				}
			}
		});
		btnBack.setBounds(221, 208, 89, 23);
		contentPane.add(btnBack);
	}
}
