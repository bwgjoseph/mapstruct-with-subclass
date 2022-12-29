package com.bwgjoseph.mapstructwithsubclass;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;

@Builder
@JsonTypeName("office")
public record OfficeAddressRequestDto(String building, String street, String postalCode, String unit) implements AddressRequestDto {}
