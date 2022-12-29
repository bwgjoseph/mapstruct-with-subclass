package com.bwgjoseph.mapstructwithsubclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class OfficeAddressDO extends AddressDO {
    private String building;
    private String street;
    private String postalCode;
    private String unit;
}
