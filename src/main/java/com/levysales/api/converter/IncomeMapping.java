package com.levysales.api.converter;

import com.levysales.api.model.IncomeOutput;
import com.levysales.api.model.Input.IncomeInput;
import com.levysales.domain.model.Income;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeMapping {

    IncomeInput toDomain(Income income);

    IncomeOutput toDTO(Income income);

}
