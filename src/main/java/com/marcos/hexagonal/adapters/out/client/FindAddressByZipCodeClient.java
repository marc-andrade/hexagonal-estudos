package com.marcos.hexagonal.adapters.out.client;

import com.marcos.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${marcos.cliente.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);
}
