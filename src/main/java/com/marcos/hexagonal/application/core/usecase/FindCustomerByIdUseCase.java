package com.marcos.hexagonal.application.core.usecase;

import com.marcos.hexagonal.application.core.domain.Customer;
import com.marcos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.marcos.hexagonal.application.ports.out.FindCustomerIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerIdOutputPort findCustomerIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerIdOutputPort findCustomerIdOutputPort) {
        this.findCustomerIdOutputPort = findCustomerIdOutputPort;
    }


    public Customer find(String id) {
        return findCustomerIdOutputPort.find(id).orElseThrow(() -> new
                RuntimeException("Customer not found"));
    }
}
