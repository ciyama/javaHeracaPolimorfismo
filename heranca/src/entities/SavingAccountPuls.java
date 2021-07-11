package entities;

public class SavingAccountPuls extends SavingsAccount {

	
	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
}
