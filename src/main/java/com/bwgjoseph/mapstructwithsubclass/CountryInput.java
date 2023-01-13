package com.bwgjoseph.mapstructwithsubclass;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CountryInput {
    private String input;

    CountryInput(String input) {
        this.input = input;
    }
}
