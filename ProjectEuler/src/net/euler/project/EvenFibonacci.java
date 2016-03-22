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
import java.awt.event.ActionEvent;

public class EvenFibonacci extends JFrame {
	
	private MainPage mainPage;
	private static EvenFibonacci frameFibo;
	private JPanel contentPane;
	private JTextField textFieldLimit;
	private JTextField textFieldEvenVal;
	private JButton btnBack;
	private JButton btnReset;
	private JButton btnGo;
	private JLabel lblMessage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameFibo = new EvenFibonacci();
					frameFibo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EvenFibonacci() {
		setTitle("Even Fibonacci");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLimit = new JLabel("Please enter the sequence value limit:");
		lblLimit.setBounds(10, 57, 209, 14);
		contentPane.add(lblLimit);
		
		textFieldLimit = new JTextField();
		textFieldLimit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldLimit.setBounds(229, 54, 113, 20);
		contentPane.add(textFieldLimit);
		textFieldLimit.setColumns(10);
		
		JLabel lblEvenVal = new JLabel("The sum of even values is: ");
		lblEvenVal.setBounds(10, 98, 184, 14);
		contentPane.add(lblEvenVal);
		
		textFieldEvenVal = new JTextField();
		textFieldEvenVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldEvenVal.setBounds(229, 95, 113, 20);
		contentPane.add(textFieldEvenVal);
		textFieldEvenVal.setColumns(10);
		
		lblMessage = new JLabel("");
		lblMessage.setBounds(10, 144, 209, 38);
		contentPane.add(lblMessage);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFibo.dispose();
				mainPage = new MainPage();
				//mainPage.setVisible(true);
			}
		});
		btnBack.setBounds(335, 0, 89, 23);
		contentPane.add(btnBack);
		
		btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int firstNum=0;
			    int secondNum=1;
			    int newNum=0;
			    int evenSum=0;
			    int limitNum=0;
			    try{
			    	limitNum=Integer.parseInt(textFieldLimit.getText());
				    if (limitNum>4000000){
				    	lblMessage.setText("You exceeded the limit of 4M.\nTry again...");
				    }
				    else{
					    boolean exceed=false;
					    while(!exceed){
//					        System.out.println("firstNum: "+firstNum+"\nsecondNum: "+secondNum+"\nlimitNum: "+limitNum+"\nevenSum: "+evenSum+"\nnewNum: "+newNum+"\n--------");
					        newNum=firstNum + secondNum;
					        //System.out.println("newNum ("+newNum+") = firstNum ("+firstNum+") + secondNum ("+secondNum+")");
					        firstNum = secondNum;
					        secondNum = newNum;

					        if(newNum > limitNum){
					            exceed=true;
					            break;
					        }

					        if(newNum % 2 == 0){
					            evenSum += newNum;
					            textFieldEvenVal.setText(Integer.toString(evenSum));
					            //System.out.println("evenSum ("+evenSum+") += newNum ("+newNum+")");
					            
					        }
					    }

					    //System.out.println(evenSum);
					}

			    	
			    }catch(Exception elimit){
			    	lblMessage.setText("Please enter valid numbers");
			    }
			}
		});
		btnGo.setBounds(335, 168, 89, 23);
		contentPane.add(btnGo);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLimit.setText("");
				textFieldEvenVal.setText("");
				lblMessage.setText("Form is cleard. Try again...");
			}
		});
		btnReset.setBounds(236, 168, 89, 23);
		contentPane.add(btnReset);
	}

}
