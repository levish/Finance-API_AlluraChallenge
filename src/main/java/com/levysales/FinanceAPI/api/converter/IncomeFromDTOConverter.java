package com.levysales.FinanceAPI.api.converter;


import com.levysales.FinanceAPI.api.model.Input.IncomeInput;
import com.levysales.FinanceAPI.domain.model.Income;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IncomeFromDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Income fromDTO(IncomeInput incomeInput) {
        return modelMapper.map(incomeInput, Income.class);
    }

    public List<Income> toCollectionDTO(List<IncomeInput> incomeInputList) {
        return incomeInputList.stream()
                .map(income -> fromDTO(income))
                .collect(Collectors.toList());
    }

    public void copyToDomain(IncomeInput incomeInput, Income income){
        modelMapper.map(incomeInput,income);
    }

}
