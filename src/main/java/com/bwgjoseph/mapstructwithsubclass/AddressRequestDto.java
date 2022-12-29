package com.bwgjoseph.mapstructwithsubclass;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
    @Type(value = HomeAddressRequestDto.class, name = "home"),
    @Type(value = OfficeAddressRequestDto.class, name = "office")
})
public interface AddressRequestDto {

}
