package entities;

public class Individual extends Payer {
	
	private Double healthExpenditures;
	
	public Individual() {
		
	}
	

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}


	@Override
	public Double taxesPaid() {
		if (getAnualIncome() < 20000.00 && healthExpenditures > 0) {
			return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
		} else if (getAnualIncome() < 20000.00 && healthExpenditures <= 0) {
			return getAnualIncome() * 0.15;
		} else if (getAnualIncome() >= 20000.00 && healthExpenditures > 0 ) {
			return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
		} else {
			return getAnualIncome() * 0.25;
		}
		
		
	}
	
	

}
