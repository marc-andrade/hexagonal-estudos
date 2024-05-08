package com.marcos.hexagonal.adapters.out;

import com.marcos.hexagonal.adapters.out.repository.CustomerRepository;
import com.marcos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.out.FindCustomerIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCustomerByIdAdapter implements FindCustomerIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
