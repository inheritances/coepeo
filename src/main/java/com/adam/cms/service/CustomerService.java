package com.adam.cms.service;

import com.adam.cms.exception.CustomerNotFoundException;
import com.adam.cms.dao.CustomerDAO;
import com.adam.cms.model.Customer;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class CustomerService {
	
    @Autowired
    private CustomerDAO customerDAO;
    
	
	private int customerIdCount=1;
	private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();
	
	public Customer addCustomer(Customer customer) {
		
		customer.setCustomerid(customerIdCount);
		customerIdCount ++;
		return customerDAO.save(customer);
	}
	
	public List<Customer> getCustomers(){
		
		return customerDAO.findAll();
		
		//return customerList;
	}
	public Customer getCustomer(int customerId) {
		
		//return customerDAO.findById(customerId).get();
		Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
		if(!optionalCustomer.isPresent())
			throw new CustomerNotFoundException("Record is not available...");
		
		return optionalCustomer.get();
	}
	public Customer updateCustomer(int customerid,Customer customer) {
		
		customer.setCustomerid(customerid);
		/*customerList
					.stream()
					.forEach(c -> {
					if(c.getCustomerid() == customerid) {
						c.setCustomerFirstName(customer.getCustomerFirstName());
						c.setCustomerLastName(customer.getCustomerLastName());
						c.setCustomerEmail(customer.getCustomerEmail());
					}
					});
		return customerList	
							.stream()
							.filter(c -> c.getCustomerid() == customerid)
							.findFirst()
							.get();*/
		return customerDAO.save(customer);
	}
	
	public void deleteCustomer(int customerid)
	{
		/*customerList	
					.stream()
					.forEach(c -> {
						if (c.getCustomerid()== customerid) {
							customerList.remove(c);
							}}); 
		}*/
		customerDAO.deleteById(customerid);
	
}
}