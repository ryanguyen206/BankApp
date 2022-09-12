import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SetTransaction extends JFrame implements ActionListener  {

	JButton button;
	JTextField textField;
	JLabel showMoney;
	private String transaction;
	BankAccount account;
	boolean success;
	int amount;

	
	SetTransaction(String transaction, BankAccount account) {
		this.account = account;
		this.transaction = transaction;
		
		showMoney = new JLabel("Balance: $" + account.getBalance());
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(100,50));
	
		
		textField.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = textField.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	textField.setEditable(true);
	              
	            } else {
	            	textField.setEditable(false);
	              
	            }
	         }
	      });
		button = new JButton(transaction);
		button.addActionListener(this);
	
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(250,250);
		this.add(button);
		this.add(textField);
		this.add(showMoney);
	
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			amount = Integer.parseInt(textField.getText());
		} catch(NumberFormatException ex){ // handle your exception
			JOptionPane.showMessageDialog(null, "CANNOT ENTER BLANK", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		int lengthOfTextField = textField.getText().length();
		System.out.println(lengthOfTextField);
	
		//withdrawl
		if (transaction.equals("Withdraw") && amount > 0 && lengthOfTextField > 0) {
					success = account.withdraw(amount);
					if(!success) {
						JOptionPane.showMessageDialog(null, "ERROR: THE AMOUNT YOU ARE TRYING TO WITHDRAW IS GREATER THAN YOUR BALANCE", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "YOUR WITHDRAWAL OF: $" + amount + " IS VALID. YOUR CURRENT BALANCE IS NOW: $" + account.getBalance(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						showMoney.setText("Balance: $" + account.getBalance());
					}
			
					textField.setText("");
		///deposit
		} else if (transaction.equals("Deposit") &&  amount >= 0 && lengthOfTextField > 0) {
					success = account.deposit(amount);
					if(success) {
						JOptionPane.showMessageDialog(null, "YOUR DEPOSIT OF: $" + amount + " HAS SUCCESSFULLY BEEN DEPOSITED. YOUR CURRENT BALANCE IS NOW: $" + account.getBalance(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						showMoney.setText("Balance: $" + account.getBalance());
					}
					textField.setText("");
		}
	
		
	}
	
	
}
