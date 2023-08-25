package Mediator;

import java.util.Vector;

import EmployeeFactory.Employee;
import Model.Chef;
import Model.Customer;
import Model.Restaurant;
import Model.Server;
import State.ServerState.ServerStateManager;

public class RestaurantMediator {
	private Restaurant resto;
	private Vector<Customer> customerIdleQueue;
	private Vector<Chef> employeeIdleQueue;
	public RestaurantMediator(Restaurant resto) {
		this.resto = resto;
		this.customerIdleQueue = new Vector<>();
		this.employeeIdleQueue = new Vector<>();
	}
	
	public void customerOutofTolerance(Customer customer) {
		removeInactiveCustomer(customer);
		resto.minusScoreCustomerOut();
	}
	
	private void removeInactiveCustomer(Customer customer) {
		resto.removeCustomer(customer.getName());
	}
	
	public void addCheftoIdleQueue(Chef emp) {
		this.employeeIdleQueue.add(emp);
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
			Customer cust = customerIdleQueue.get(0);
			customerIdleQueue.remove(0);
			cust.getCurrState().setServer(employee);;
			employee.getCurrState().setCustomer(cust);
			return true;
		}
		return false;
	}
	
	public synchronized Boolean checkAvailableChef(Server server) {
		if(!employeeIdleQueue.isEmpty()) {
			Chef emp = employeeIdleQueue.get(0);
			employeeIdleQueue.remove(0);
			server.getCurrState().setChef(emp);
			return true;
		}
		return false;
	}
	
	public synchronized Boolean checkDoneChef(Server server) {
		if(!employeeIdleQueue.isEmpty()) {
			for (Chef chef : employeeIdleQueue) {
				if(chef.getCurrState().getCurrState() == chef.getCurrState().getDoneState()) {
					Chef emp = employeeIdleQueue.get(0);
					employeeIdleQueue.remove(0);
					server.getCurrState().setChef(emp);
					return true;
				}
			}
		}
		return false;
	}
	
	public synchronized void chefAssignJob(Customer cu, Server server, Chef emp) {
		if(emp.getCurrState().getCurrState() == emp.getCurrState().getIdleState()) {
			emp.getCurrState().setCustomer(cu);
			cu.getCurrState().setChef(emp);
			cu.getCurrState().changeState(cu.getCurrState().getWaitChefState());
			emp.getCurrState().changeState(emp.getCurrState().getCookState());
			server.getCurrState().changeState(server.getCurrState().getIdleState());
		}else if(emp.getCurrState().getCurrState() == emp.getCurrState().getDoneState()) {
			Customer servCustomer = server.getCurrState().getCustomer();
			Customer chefCustomer = emp.getCurrState().getCustomer();
			servCustomer.getCurrState().setChef(emp);
			servCustomer.getCurrState().changeState(servCustomer.getCurrState().getWaitChefState());
			server.getCurrState().setCustomer(chefCustomer);
			server.getCurrState().changeState(server.getCurrState().getServingFoodState());
			emp.getCurrState().setCustomer(servCustomer);
			emp.getCurrState().changeState(emp.getCurrState().getCookState());
		}
	}
	
	public void customerdoneEating(Customer cu, Chef chef) {
		this.resto.gainMoney(chef.getSkill()*30);
		this.resto.gainScore(chef.getSkill()*30);
		this.resto.getCustomers().remove(cu.getName());
		cu.setShouldStop(true);
		
		
	}
	
	public synchronized void customerWaitFood(Customer customer) {
		customer.getCurrState().changeState(customer.getCurrState().getWaitState());
	}

}
