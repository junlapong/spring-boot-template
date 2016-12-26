package hello.rest;

import hello.domain.Customer;
import hello.repository.CustomerRepository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestService.class);

    @Autowired
    CustomerRepository customerRepo;

    @RequestMapping(value = "/rest/customer", method = RequestMethod.GET)
    public Iterable<Customer> getAllCustomers() {
        Iterable<Customer> customerLst = customerRepo.findAll();
        return customerLst;
    }

    @RequestMapping(value = "/rest/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        Customer customer = customerRepo.findOne(id);
        return customer;
    }

    @RequestMapping(value = "/rest/customer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        logger.info("First Name: " + customer.getFirstName() + ", Last Name: " + customer.getLastName());
        customerRepo.save(customer);
        return new ResponseEntity(customer.getId(), HttpStatus.OK);

    }

    @RequestMapping(value = "/rest/time", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Customer> serverTime() {
        return new ResponseEntity("ServerTime : " + new Date(), HttpStatus.OK);
    }

}
