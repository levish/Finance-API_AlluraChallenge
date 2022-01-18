package com.levysales.FinanceAPI.api.model.Input;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class IncomeInput {

    @NotBlank
    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal value;

    @DateTimeFormat
    private LocalDateTime date;
}
