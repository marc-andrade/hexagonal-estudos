package com.marcos.hexagonal.application.ports.in;

import com.marcos.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
