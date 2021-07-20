package cg.wbd.grandemonstration.model.service;

import cg.wbd.grandemonstration.model.bean.Customer;
import cg.wbd.grandemonstration.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }


}
