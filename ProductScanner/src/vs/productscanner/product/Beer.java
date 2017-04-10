package vs.productscanner.product;

public class Beer implements Product{
public final static String PRODUCT_NAME = "Beer";
	private double ammount;
	
	@Override
	public String getName() {
		return PRODUCT_NAME;
	}

	@Override
	public String getUnit() {
		return "Liter";
	}

	@Override
	public String getStateAsString() {
		return String.format("%s;%s;%s", this.getName(), Double.toString(this.getAmmount()), getUnit());
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
}