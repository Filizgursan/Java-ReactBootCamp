package inheritance;

public class Main {

	public static void main(String[] args) {
		
		IndividualCustomer filiz = new IndividualCustomer();
		filiz.customerNumber = "12345";
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.customerNumber = "78910";
		
		CustomerManager customerManager = new CustomerManager();
		//customerManager.add(hepsiBurada);
		//customerManager.add(filiz);
		Customer[] customers = {filiz, hepsiBurada};
		customerManager.addMultiple(customers);
		
	}
}
