package eu.papenhagen.spingdemo.boundary;

import eu.papenhagen.spingdemo.entity.Customer;
import eu.papenhagen.spingdemo.exception.ResourceNotFoundException;
import eu.papenhagen.spingdemo.repository.CustomerRepository;
import java.util.HashMap;

import java.util.List;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * CRUD for Customer
 *
 * @author Jens Papenhagen
 */
@RestController
@RequestMapping("/api/v1")
public class CustomerResource {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
            @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customer.setLastName(customerDetails.getLastName());
        customer.setFirstName(customerDetails.getFirstName());

        final Customer updatedCustomer = repository.save(customer);

        return ResponseEntity.ok(updatedCustomer);

    }

    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {
        Customer customer = repository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        repository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
