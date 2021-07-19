package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer update(Customer customer);

    void save(Customer customer);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
