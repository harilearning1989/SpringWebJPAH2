package com.web.demo.services;

import com.web.demo.model.Customer;
import com.web.demo.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import java.util.List;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		if(customerList.isEmpty()){
			Customer customer = null;
			for(int i=0;i<5;i++){
				customer = new Customer();
				customer.setFirstName("Hari-"+i);
				customer.setLastName("Duddukunta"+i);
				customer.setEmail("hari.duddukunta@gmail.com");
				customerRepository.save(customer);
			}
			return customerRepository.findAll();
		}
		return customerList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}
}





