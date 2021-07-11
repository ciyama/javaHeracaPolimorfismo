package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of product: ");
		int n = sc.nextInt();
		
		for (int d=1; d<=n; d++) {
			System.out.println("Product #" + d + " data:");
			System.out.print("Common, used, or imported (c/u/i)? ");
			char sit = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (sit == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, customsFee);
				list.add(prod);
			} else if (sit == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product prod = new UsedProduct(name, price, manufactureDate);
				list.add(prod);
				
			} else if (sit == 'c') {
				list.add(new Product(name, price));
			}
			
			System.out.println("PRICE TAGS: ");
			for (Product product : list) {
				System.out.println(product.priceTag());
			}
			
			
		}
		
		
		sc.close();
	}
}
