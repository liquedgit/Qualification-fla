package Observer;

import java.util.HashMap;

import Mediator.RestaurantMediator;
import Model.Customer;

public interface Observer {
	public void getNotif(int emptySeat,HashMap<String, Customer> customer, RestaurantMediator mediator);
}
