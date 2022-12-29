package com.bwgjoseph.mapstructwithsubclass;

import lombok.Builder;

@Builder
public record OfficeAddressResponseDto(String id, String building, String street, String postalCode, String unit, String createdBy, String createdAt) implements AddressResponseDto {}
