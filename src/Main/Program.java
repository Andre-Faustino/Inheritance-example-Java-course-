package Main;

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
		
		Locale.setDefault(Locale.ENGLISH);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i): ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			if( c == 'c') {
				System.out.print("Name : ");
				String name = sc.nextLine();
				System.out.print("Price : ");
				Double price = sc.nextDouble();
				
				productList.add(new Product(name, price));
				
			}else if( c == 'i') {
				System.out.print("Name : ");
				String name = sc.nextLine();
				System.out.print("Price : ");
				Double price = sc.nextDouble();
				System.out.print("Customs Fee : ");
				Double customsFee = sc.nextDouble();
				
				
				productList.add(new ImportedProduct(name, price, customsFee));
				
			}else {
				System.out.print("Name : ");
				String name = sc.nextLine();
				System.out.print("Price : ");
				Double price = sc.nextDouble();
				
				System.out.print("Manufactured Date (DD/MM/YYYY) : ");
				Date manufacturedDate = sdf.parse(sc.next());
				
				productList.add(new UsedProduct(name, price, manufacturedDate));
			}
		}
		
		System.out.println("\nPRICE TAGS:");
		for (Product p : productList) {
			System.out.println(p.priceTag());
		}
	}

}
