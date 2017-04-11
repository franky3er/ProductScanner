package vs.productscanner.product;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScannedProduct implements Product {
	public final static SimpleDateFormat SCANNED_PRODUCT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private Product product;
	private Date timeStamp;

	public ScannedProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String getName() {
		return this.product.getName();
	}

	@Override
	public String getUnit() {
		return this.product.getUnit();
	}

	@Override
	public String getStateAsString() {
		return String.format("%s;%s", this.product.getStateAsString(), SCANNED_PRODUCT_DATE_FORMAT.format(this.timeStamp));
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public void setAmmount(String ammount) {
		this.product.setAmmount(ammount);
	}
	
}
