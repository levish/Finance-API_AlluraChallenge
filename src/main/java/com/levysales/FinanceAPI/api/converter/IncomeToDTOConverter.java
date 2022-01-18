package com.levysales.FinanceAPI.api.converter;


import com.levysales.FinanceAPI.api.model.IncomeOutput;
import com.levysales.FinanceAPI.domain.model.Income;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IncomeToDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public IncomeOutput toDTO(Income income) {
        return modelMapper.map(income, IncomeOutput.class);
    }

    public List<IncomeOutput> toCollectionDTO(List<Income> incomeList) {
        return incomeList.stream()
                .map(income -> toDTO(income))
                .collect(Collectors.toList());
    }


}
