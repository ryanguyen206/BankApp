
public class BankAccount {

	
	private String userName;
	private String pin;
	private int balance;
	private boolean isAdmin;
	
	
	BankAccount(String userName, String pin, int balance, boolean isAdmin) {
		setUsername(userName);
		setPin(pin);
		setBalance(balance);
		setAdmin(isAdmin);
	}
	
	public boolean deposit(int amount) {
		setBalance(getBalance() + amount);
		return true;
	}
	
	public boolean withdraw(int amount) {
		if (amount > this.balance) {
			return false;
		} else {
			setBalance(getBalance() - amount);
		}
		
	return true;
		
	}
	
	public void setAdmin(boolean admin) {
		this.isAdmin = admin;
	}
	

	public void setUsername(String username) {
		this.userName = username;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public boolean getAdmin() {
		return this.isAdmin;
	}
	public String getUserName() {
		return this.userName;
	}
	
	public String getPin() {
		return this.pin;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
}
