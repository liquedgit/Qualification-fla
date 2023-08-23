package Facade;

import java.util.HashMap;
import java.util.Random;

import EmployeeFactory.ChefFactory;
import EmployeeFactory.Employee;
import EmployeeFactory.EmployeeFactory;
import EmployeeFactory.ServerFactory;

public class EmployeeGenerator {
	private Random random;
	
	public EmployeeGenerator(){
		this.random = new Random();
	}
	
	private String generateInitial(HashMap<String, Employee> employee) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String initial;
		do {
			char firstChar = alphabet.charAt(random.nextInt(alphabet.length()));
            char secondChar = alphabet.charAt(random.nextInt(alphabet.length()));
            initial = String.valueOf(firstChar) + String.valueOf(secondChar);
		}while(employee.get(initial) != null);
		return initial;
	}
	
	public void generateServer(HashMap<String, Employee> employee, Integer count) {
		EmployeeFactory serverFactory = new ServerFactory();
		for(int i = 0;i<count;i++) {
			String initial = generateInitial(employee);
			Employee server = serverFactory.createEmployee(initial);
			employee.put(initial, server);
		}
	}
	
	public void generateChef(HashMap<String, Employee> employee, Integer count ) {
		EmployeeFactory chefFactory = new ChefFactory();
		for(int i = 0;i<2;i++) {
			String initial = generateInitial(employee);
			Employee chef = chefFactory.createEmployee(initial);
			employee.put(initial, chef);
		}
	}
	
}
