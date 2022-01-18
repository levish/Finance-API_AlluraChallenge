package com.levysales.api.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OutgoingOutput {
    private long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime date;
}
