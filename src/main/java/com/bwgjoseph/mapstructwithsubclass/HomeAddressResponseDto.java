package com.bwgjoseph.mapstructwithsubclass;

import lombok.Builder;

@Builder
public record HomeAddressResponseDto(String id, String street, String postalCode, String unit, String createdBy, String createdAt) implements AddressResponseDto {}
