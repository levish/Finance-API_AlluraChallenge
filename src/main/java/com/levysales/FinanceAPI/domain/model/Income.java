package com.levysales.FinanceAPI.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Data
public class Income {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private BigDecimal value;

    private LocalDateTime date;

}

