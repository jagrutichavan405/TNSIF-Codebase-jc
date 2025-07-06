
public class singleInheritance {

	public  class Citizen {
		
		private string name;
		private string adhaar;
		private string  number;
		private long = phone;
		
		public Citizen() {
			System.out.println("Citizen obj created");
		}
		

		//para constructor 
		public Citizen(String name, String adharNo, String address, long phone) {
			
			this.name = name;
			this.adharNo = adharNo;
			this.address = address;
			this.phone = phone;
		}
		
		
		
		public string getName() {
			return name;
		}
		public void setName(string name) {
			this.name = name;
		}
		public string getAdhaar() {
			return adhaar;
		}
		public void setAdhaar(string adhaar) {
			this.adhaar = adhaar;
		}
		public long getNumber() {
			return number;
		}
		public void setNumber (long number) {
			this.number = number;
		}


		@Override
		public String toString() {
			return "Citizen [getNumber()=" + getNumber() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		
		 
	}

}
