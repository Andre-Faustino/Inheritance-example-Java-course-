package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private Date manufacturedDate;
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}


	@Override
	public String priceTag () {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " (used) $ " + String.format("%.2f", getPrice()) + " (Manufactured Date: " + sdf1.format(manufacturedDate) + ")");
		return sb.toString();		
	}
}
