package Observer;

import java.util.HashMap;
import java.util.Random;

import Mediator.RestaurantMediator;
import Model.Customer;
import Multithread.CustomerThread;

public class CustomerGenerator implements Observer{
	private Random random;
	
	public CustomerGenerator() {
		this.random = new Random();
	}
	
	private String generateInitial(HashMap<String, Customer>customer) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String initial;
		do {
			char firstChar = alphabet.charAt(random.nextInt(alphabet.length()));
			char secondChar = alphabet.charAt(random.nextInt(alphabet.length()));
			initial = String.valueOf(firstChar) + String.valueOf(secondChar);
		}while(customer.containsKey(initial));
		
		return initial;
	}
	
	public void generateCustomer(HashMap<String, Customer> customers,int emptySeats, RestaurantMediator mediator) {
		Integer number = random.nextInt(100);
		if(number <= 25) {
			String initial = generateInitial(customers);
			Customer customer = new Customer(initial, 10, mediator);
			customers.put(initial, customer);
			new Thread(new CustomerThread(customer)).start();
		}
	}

	@Override
	public void getNotif(int emptySeat, HashMap<String, Customer> customer, RestaurantMediator mediator) {
		// TODO Auto-generated method stub
		generateCustomer(customer, emptySeat, mediator);
	}
	
	
}
