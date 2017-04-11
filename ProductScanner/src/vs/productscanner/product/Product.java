package vs.productscanner.product;

public interface Product {
	String getName();
	String getUnit();
	String getStateAsString();
	
	/**
	 * Parses the given String to the right ammount data type (e.g. double, int, float, etc.)
	 * and sets the ammount attribute in the concrete product class
	 * 
	 * @param ammount
	 */
	void setAmmount(String ammount);
}