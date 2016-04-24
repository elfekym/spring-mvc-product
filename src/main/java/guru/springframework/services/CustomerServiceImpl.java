package guru.springframework.services;

import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by reve99 on 4/24/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer,Customer> customers;
    public CustomerServiceImpl(){
        loadProducts();
    }

    private void loadProducts() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Mohamed");
        customer1.setLastName("El-Feky");
        customer1.setAddressLine_2("2nd Floor");
        customer1.setAddressLine_1("40 Palestine St");
        customer1.setCity("Cairo");
        customer1.setState("Cairo");
        customer1.setEmail("m@m.m");
        customer1.setPhoneNumber("0110011001");
        customers.put(1,customer1);

        Customer customer2 = new Customer();
        customer2.setId(1);
        customer2.setFirstName("Mohamed");
        customer2.setLastName("El-Feky");
        customer2.setAddressLine_2("2nd Floor");
        customer2.setAddressLine_1("40 Palestine St");
        customer2.setCity("Cairo");
        customer2.setState("Cairo");
        customer2.setEmail("m@m.m");
        customer2.setPhoneNumber("0110011001");
        customers.put(2,customer2);
    }

        @Override
    public List<Customer> listAllCustomers() {
            return new ArrayList<>(customers.values());
        //return null;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {

        if(customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
            return customer;
        }else{
            throw new RuntimeException("Product Can't be null");
        }

    }


    private Integer getNextKey() {
        return Collections.max(customers.keySet())+1;
    }
    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }
}
