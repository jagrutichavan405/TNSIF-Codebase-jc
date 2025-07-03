package new3;

public class constructor {

	private  String customerName;
	private int customerId;
	private String customCity;
	
	
	
	public void  customer() {
		System.out.println("this is default==============!");
		}



  // para constructor
	public constructor(String customerName, int customerId, String customCity) {
		System.out.println(" this is para constructor");
		this.customerName = customerName;
		this.customerId = customerId;
		this.customCity = customCity;
	}

  // getter and stter
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomCity() {
		return customCity;
	}


	public void setCustomCity(String customCity) {
		this.customCity = customCity;
	}
		 
	

}
