import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainGUI implements ActionListener{
		
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton depositBtn;
	JButton withdrawBtn;
	JButton admnBtn;
	BankAccount currentAccount;
	SetTransaction queueTransaction;
	
	BankDb bankdb = new BankDb();
	ArrayList<BankAccount> bankAccounts = bankdb.accountsArray;
	


	MainGUI(BankAccount validAccount) {
		currentAccount = validAccount;
		label = new JLabel("Welcome " + validAccount.getUserName());
		label.setBounds(0,0,500,100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
	
		//btn options
		depositBtn = new JButton("Deposit");
		depositBtn.setBounds(125, 150, 215, 30);
		depositBtn.addActionListener(this);
		withdrawBtn = new JButton("Withdraw");
		withdrawBtn.setBounds(125, 200, 215, 30);
		withdrawBtn.addActionListener(this);
		admnBtn = new JButton("Admin");
		admnBtn.setBounds(125, 250, 215, 30);
		admnBtn.addActionListener(this);
		
		//panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(label);
		panel.add(depositBtn);
		panel.add(withdrawBtn);
		panel.add(admnBtn);
		
		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	
		frame.add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == depositBtn) {
			if(queueTransaction != null) {
				queueTransaction.dispose();
			}
			queueTransaction = new SetTransaction("Deposit", currentAccount);
		
		}
		if (e.getSource() == withdrawBtn) {
			if(queueTransaction != null) {
				queueTransaction.dispose();
			}
			queueTransaction = new SetTransaction("Withdraw", currentAccount);
		}
		
		if (e.getSource() == admnBtn) {
			if(!currentAccount.getAdmin()) {
				JOptionPane.showMessageDialog(null, "ERROR: YOU DO NOT HAVE ACCESS TO ADMIN PORTAL", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				for (int i=0; i <bankAccounts.size(); i++) {
					System.out.println("Name: " + bankAccounts.get(i).getUserName());
					System.out.println("PIN:" + bankAccounts.get(i).getPin());
					System.out.println("Admin:" + bankAccounts.get(i).getAdmin());
					System.out.println("----------------------------------------");
				}
			}
		
		}
		
	}

	
}
