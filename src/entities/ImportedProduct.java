package entities;

public class ImportedProduct extends Product{
	
	private Double customsFee;

	
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}


	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag () {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " $ " + String.format("%.2f", totalPrice()) + " (Customs fee: $ " + customsFee + ")");
		return sb.toString();		
	}
	
}
