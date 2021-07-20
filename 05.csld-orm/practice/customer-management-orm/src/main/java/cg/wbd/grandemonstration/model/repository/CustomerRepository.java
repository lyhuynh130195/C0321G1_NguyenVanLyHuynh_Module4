package cg.wbd.grandemonstration.model.repository;


import cg.wbd.grandemonstration.model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer update(Customer customer);

    void save(Customer customer);

    void delete(Long id);

    void delete(Customer customer);

}
