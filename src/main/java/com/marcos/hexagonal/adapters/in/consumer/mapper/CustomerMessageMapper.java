package com.marcos.hexagonal.adapters.in.consumer.mapper;

import com.marcos.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.marcos.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
