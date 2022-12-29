package com.bwgjoseph.mapstructwithsubclass;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressMapper addressMapper;

    @PostMapping
    public AddressResponseDto create(@RequestBody AddressRequestDto addressDto) {
        if (addressDto instanceof HomeAddressRequestDto) {
            System.out.println("home");
        }

        if (addressDto instanceof OfficeAddressRequestDto) {
            System.out.println("office");
        }

        AddressDO addressDO = this.addressMapper.toDomainObject(addressDto);
        addressDO = addressDO.toBuilder().id("12345").auditable(Auditable.builder().createdBy("Joseph").createdAt(LocalDateTime.now()).build()).build();

        log.info("{}", addressDO);

        AddressResponseDto addressResponseDto = this.addressMapper.toDto(addressDO);
        log.info("{}", addressResponseDto);

        return addressResponseDto;
    }
}
