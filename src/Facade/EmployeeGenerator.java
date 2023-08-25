package Facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import EmployeeFactory.ChefFactory;
import EmployeeFactory.Employee;
import EmployeeFactory.EmployeeFactory;
import EmployeeFactory.ServerFactory;
import Mediator.RestaurantMediator;
import Model.Chef;
import Model.Server;
import Multithread.ChefThread;
import Multithread.ServerThread;

public class EmployeeGenerator {
	private Random random;
	
	public EmployeeGenerator(){
		this.random = new Random();
	}
	
	private String generateInitial(HashMap<String, Employee> employee) {
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Set<String> possibleInitials = new HashSet<>();
	    for (char c1 : alphabet.toCharArray()) {
	        for (char c2 : alphabet.toCharArray()) {
	            possibleInitials.add("" + c1 + c2);
	        }
	    }

	    possibleInitials.removeAll(employee.keySet()); // remove existing initials

	    if (possibleInitials.isEmpty()) {
	        throw new IllegalStateException("No unique initials left!");
	    }

	    List<String> remainingInitials = new ArrayList<>(possibleInitials);
	    return remainingInitials.get(random.nextInt(remainingInitials.size()));
	}
	
	public void generateServer(HashMap<String, Employee> employee, Integer count, RestaurantMediator mediator) {
		EmployeeFactory serverFactory = new ServerFactory(mediator);
		for(int i = 0;i<count;i++) {
			String initial = generateInitial(employee);
			Employee server = serverFactory.createEmployee(initial);
			employee.put(initial, server);
			new Thread(new ServerThread((Server)server)).start();
		}
	}
	
	public void generateChef(HashMap<String, Employee> employee, Integer count, RestaurantMediator mediator ) {
		EmployeeFactory chefFactory = new ChefFactory(mediator);
		for(int i = 0;i<2;i++) {
			String initial = generateInitial(employee);
			Employee chef = chefFactory.createEmployee(initial);
			employee.put(initial, chef);
			new Thread(new ChefThread((Chef)chef)).start();
		}
	}
	
}
