package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BusinessAccount account = new BusinessAccount();
		
		account.getBalance();
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING
		
		Account acc1 = bacc; // subclasse bacc pode ser atriguida a auma acc1 que é a superclasse, pois bacc é uma acc1
		acc1.getBalance();
		
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		
		// DOWNCAST
		
		//BusinessAccount bacc1 = acc2; // nao aceita downcastin direto, temos que realizar um downcasting manual
		//acc2.loan(); // nao acessa pois nao esta realizado o downcasting, a função loan está em BusinessAccount
		BusinessAccount bacc2 = (BusinessAccount)acc2;
		bacc2.loan(100.0);
		
		//BusinessAccount bacc3 = (BusinessAccount)acc3; // nao ocorre erro de sintaxe pois o acc3 ainda não sabe que ele é do tipo SavingsAccount ainda ele retornará erro somente na compilação.
		// para realizarmos esta operação utilizamos o instanceof
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount bacc4 = (BusinessAccount)acc3;
			bacc4.loan(200.0);
			System.out.println("Loan!");
 		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount bacc5 = (SavingsAccount)acc3;
			bacc5.updateBalance();
			System.out.println("Update!");
		}
		

	}

}
