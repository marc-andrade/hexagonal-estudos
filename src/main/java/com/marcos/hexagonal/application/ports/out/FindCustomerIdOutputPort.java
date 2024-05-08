package com.marcos.hexagonal.application.ports.out;

import com.marcos.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerIdOutputPort {

    Optional<Customer> find(String id);
}
