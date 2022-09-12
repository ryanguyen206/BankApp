import java.util.ArrayList;

public class BankDb {
	
	ArrayList<BankAccount> accountsArray = new ArrayList<BankAccount>();
	
	public BankDb() {
		BankAccount one = new BankAccount("1", "1", 1000, true);
		BankAccount two = new BankAccount("two", "4502", 0, false);
		BankAccount three = new BankAccount("three", "1023", 20000, false);
		accountsArray.add(one);
		accountsArray.add(two);
		accountsArray.add(three);
	
		
	}
	
	public BankAccount verify(String username, String pin) {
		
		for (int i = 0; i < accountsArray.size(); i++) {
            String tempPin = accountsArray.get(i).getPin();  
            String tempUser = accountsArray.get(i).getUserName();
      
            if (username.equals(tempUser) && pin.equals(tempPin)) {
            	return accountsArray.get(i);
           }         
      
		}
		return null;
	}
	
}
	
