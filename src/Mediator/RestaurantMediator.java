package Mediator;

import java.util.Vector;

import EmployeeFactory.Employee;
import Model.Customer;
import Model.Restaurant;
import Model.Server;
import State.ServerState.ServerStateManager;

public class RestaurantMediator {
	private Restaurant resto;
	private Vector<Customer> customerIdleQueue;
	public RestaurantMediator(Restaurant resto) {
		this.resto = resto;
		this.customerIdleQueue = new Vector<>();
	}
	
	public void customerOutofTolerance(Customer customer) {
		removeInactiveCustomer(customer);
		resto.minusScoreCustomerOut();
	}
	
	private void removeInactiveCustomer(Customer customer) {
		resto.getCustomers().remove(customer.getName());
	}
	
	public void addCustomertoIdleQueue(Customer customer) {
		customerIdleQueue.add(customer);
	}

	public Restaurant getResto() {
		return resto;
	}

	public void setResto(Restaurant resto) {
		this.resto = resto;
	}

	public Vector<Customer> getCustomerIdleQueue() {
		return customerIdleQueue;
	}

	public void setCustomerIdleQueue(Vector<Customer> customerIdleQueue) {
		this.customerIdleQueue = customerIdleQueue;
	}

	public synchronized Boolean serverAssignJob(Server employee) {
		if(!customerIdleQueue.isEmpty()) {
			System.out.println("Assigned job");
			Customer cust = customerIdleQueue.get(0);
			customerIdleQueue.remove(0);
			cust.setInteractWith(employee);
			employee.getCurrState().setCustomer(cust);
			return true;
		}
		return false;

	}

}
