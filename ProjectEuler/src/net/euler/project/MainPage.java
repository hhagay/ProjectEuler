
package net.euler.project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private MainPage window;
	private JFrame frameMainPage;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private JLabel lblMessage;
	private JButton btnExit;
	private JButton btnReset;
	private JButton btnGo;
	private SumNumbers problem1;
	private EvenFibonacci problem2;
	private PrmeFactor problem3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frameMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMainPage = new JFrame();
		frameMainPage.setTitle("Project Euler Main Page");
		frameMainPage.setBounds(100, 100, 450, 300);
		frameMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMainPage.getContentPane().setLayout(null);
		
		rdbtn1 = new JRadioButton("Problem 1");
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn1.isSelected())
					rdbtn2.setSelected(false);
				rdbtn3.setSelected(false);
			}
		});
		rdbtn1.setBounds(6, 7, 109, 23);
		frameMainPage.getContentPane().add(rdbtn1);
		
		rdbtn2 = new JRadioButton("Problem 2");
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn2.isSelected())
					rdbtn1.setSelected(false);
				rdbtn3.setSelected(false);
				
			}
		});
		rdbtn2.setBounds(6, 33, 109, 23);
		frameMainPage.getContentPane().add(rdbtn2);
		
		rdbtn3 = new JRadioButton("Problem 3");
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn3.isSelected())
					rdbtn1.setSelected(false);
				rdbtn2.setSelected(false);

			}
		});
		rdbtn3.setBounds(6, 59, 109, 23);
		frameMainPage.getContentPane().add(rdbtn3);
		
		lblMessage = new JLabel("");
		lblMessage.setBounds(192, 59, 193, 23);
		frameMainPage.getContentPane().add(lblMessage);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 215, 89, 23);
		frameMainPage.getContentPane().add(btnExit);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtn1.setSelected(false);
				rdbtn2.setSelected(false);
				rdbtn3.setSelected(false);
				lblMessage.setText("Form cleared successfully");
			}
		});
		btnReset.setBounds(335, 181, 89, 23);
		frameMainPage.getContentPane().add(btnReset);
		
		btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtn1.isSelected()){
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
					lblMessage.setText("");
					//frameMainPage.dispose();
					problem1 = new SumNumbers();
					problem1.setVisible(true);
				}
				else if(rdbtn2.isSelected()){
					rdbtn1.setSelected(false);
					rdbtn3.setSelected(false);
					lblMessage.setText("");
					//frameMainPage.dispose();
					problem2 = new EvenFibonacci();
					problem2.setVisible(true);
				}
				else if (rdbtn3.isSelected()){
					rdbtn1.setSelected(false);
					rdbtn2.setSelected(false);
					lblMessage.setText("");
					//frameMainPage.dispose();
					problem3 = new PrmeFactor();
					problem3.setVisible(true);
				}
				else{
					lblMessage.setText("Please make a selection");
				}
			}
		});
		btnGo.setBounds(335, 149, 89, 23);
		frameMainPage.getContentPane().add(btnGo);
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		this.setVisible(b);
//		
//	}

}
