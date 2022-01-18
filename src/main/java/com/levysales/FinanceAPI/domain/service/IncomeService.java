package com.levysales.FinanceAPI.domain.service;

import com.levysales.FinanceAPI.domain.exceptions.ReleaseNotFoundException;
import com.levysales.FinanceAPI.domain.model.Income;
import com.levysales.FinanceAPI.domain.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeService {

    public static final String INCOME_NOTFOUND = "Receita não encontrada";

    @Autowired
    private IncomeRepository incomeRepository;

    @Transactional
    public Income toSave(Income income){
        return incomeRepository.save(income);
    }

    @Transactional
    public void toDelete(Long incomeId){
        try {
            incomeRepository.deleteById(incomeId);
            incomeRepository.flush();
        } catch (EmptyResultDataAccessException e ){
            throw new ReleaseNotFoundException(String.format(INCOME_NOTFOUND,incomeId));
        }
    }

    public Income findOrFail(Long incomeId){
        return incomeRepository.findById(incomeId).orElseThrow(
        () -> new ReleaseNotFoundException(String.format(INCOME_NOTFOUND,incomeId)));
    }



}
