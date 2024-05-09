package com.marcos.hexagonal.adapters.in.consumer;

import com.marcos.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.marcos.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.marcos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceivedValidateCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort customerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "marcos")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        customerInputPort.update(customer, customerMessage.getZipCode());
    }
}
