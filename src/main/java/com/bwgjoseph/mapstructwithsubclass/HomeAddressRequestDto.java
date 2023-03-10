package com.bwgjoseph.mapstructwithsubclass;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;

@Builder
@JsonTypeName("home")
public record HomeAddressRequestDto(String id, String street, String postalCode, String unit, String createdBy, String createdAt, String country, Point location) implements AddressRequestDto {}
