package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payer;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Payer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthexpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthexpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		double totalTaxes = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Payer payer : list) {
			System.out.println( payer.getName() + ": $ " + String.format("%.2f", payer.taxesPaid()));
			totalTaxes += payer.taxesPaid();
		}
		
//		for (Payer payer : list) {
	//	}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + totalTaxes);
		sc.close();
	}

}
