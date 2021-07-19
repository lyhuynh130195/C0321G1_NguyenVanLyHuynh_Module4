package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements CustomerService {
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
    public boolean exists(Long id) {
        return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return customerRepository.findAll(ids);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
