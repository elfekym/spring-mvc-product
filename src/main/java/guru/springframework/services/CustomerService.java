package guru.springframework.services;

import guru.springframework.domain.Customer;

import java.util.List;

/**
 * Created by reve99 on 4/24/2016.
 */
public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
