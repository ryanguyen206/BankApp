import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class StartBank implements ActionListener {
	 JFrame frame;
	 JPanel panel;
	 JLabel welcomeLabel;
	 JLabel userLabel;
	 JLabel passwordLabel;
	 JButton loginButton;
	 JTextField userTextField;
	 JPasswordField userPasswordField;
	 JLabel success;
	 BankDb bankdb;
			
	StartBank() {
		
		bankdb = new BankDb();
		
		welcomeLabel = new JLabel("Welcome! Please Login");
		welcomeLabel.setBounds(10, 20, 300, 25);

		//User - password labels + input fields
		userLabel = new JLabel("User:");
		userLabel.setBounds(10,70,80,25);
		userTextField = new JTextField();
		userTextField.setBounds(100, 70, 165, 25);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10,100,80,25);
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(100, 100, 165, 25);
		
		//button
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setBounds(10, 150, 80, 25);
		
		//Invisible login
		success = new JLabel("");
		success.setBounds(10, 170, 100, 25);
		
		
		//Panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(userLabel);
		panel.add(userTextField);
		panel.add(passwordLabel);
		panel.add(userPasswordField);
		panel.add(loginButton);
		panel.add(welcomeLabel);
		//Frame
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String userInput = userTextField.getText().trim();
		String passwordInput = userPasswordField.getText().trim();
		BankAccount validAccount = bankdb.verify(userInput, passwordInput);
		if (validAccount != null) {
			frame.dispose();
			MainGUI newWindow = new MainGUI(validAccount);
		} else {
			JOptionPane.showMessageDialog(null, "ERROR: INVALID CREDENTIALS. PLEASE TRY AGAIN", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
