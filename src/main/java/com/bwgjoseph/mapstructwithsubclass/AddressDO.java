package com.bwgjoseph.mapstructwithsubclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class AddressDO {
    public abstract AddressDOBuilder<?, ?> toBuilder();

    private String id;
    private Auditable auditable;
}
