package entities;

public class Company extends Payer {
	
	private int numberOfEmployee;
	
	public Company() {
		
	}

	public Company(String name, Double anualIncome, int numberOfEmployee) {
		super(name, anualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public Double taxesPaid() {
		if (numberOfEmployee > 10 ) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
	
	
	
}
