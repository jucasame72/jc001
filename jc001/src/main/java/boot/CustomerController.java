package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestParam("firstName") String firstName, 
			@RequestParam ("lastName") String lastName){
		Customer customer = null;
		try{
			customer = new Customer(firstName, lastName);
			customerRepository.save(customer);
		}catch(Exception ex){
			return "Error creating the customer: " + ex.toString();
		}
		return "User succesfully created! (id = " + customer.getId() + ")";
	}

}
