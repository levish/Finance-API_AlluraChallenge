package com.levysales.FinanceAPI.api.controller;

import com.levysales.FinanceAPI.api.converter.IncomeFromDTOConverter;
import com.levysales.FinanceAPI.api.converter.IncomeToDTOConverter;
import com.levysales.FinanceAPI.api.model.IncomeOutput;
import com.levysales.FinanceAPI.api.model.Input.IncomeInput;
import com.levysales.FinanceAPI.domain.exceptions.ReleaseNotFoundException;
import com.levysales.FinanceAPI.domain.model.Income;
import com.levysales.FinanceAPI.domain.repository.IncomeRepository;
import com.levysales.FinanceAPI.domain.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private IncomeToDTOConverter incomeToDTOConverter;

    @Autowired
    private IncomeFromDTOConverter incomeFromDTOConverter;

    @GetMapping
    public List<IncomeOutput> listAll() {
        List<Income> incomeList = incomeRepository.findAll();
        return incomeToDTOConverter.toCollectionDTO(incomeList);
    }

    @GetMapping("/{incomeId}")
    public IncomeOutput findById(@PathVariable Long incomeId) {
        Income income = incomeService.findOrFail(incomeId);
        return incomeToDTOConverter.toDTO(income);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncomeOutput toAdd(@RequestBody @Valid IncomeInput incomeInput) {
        Income income = incomeFromDTOConverter.fromDTO(incomeInput);
        return incomeToDTOConverter.toDTO(incomeService.toSave(income));
    }

    @PutMapping("/{incomeId}")
    public IncomeOutput toUpdate(@PathVariable Long incomeId, @RequestBody @Valid IncomeInput incomeInput) {
        try {
            Income income = incomeService.findOrFail(incomeId);
            incomeFromDTOConverter.copyToDomain(incomeInput,income);

            return incomeToDTOConverter.toDTO(income);
        } catch (ReleaseNotFoundException e){
            throw new ReleaseNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{incomeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void toDelete(@PathVariable Long incomeId) {
        incomeService.toDelete(incomeId);
    }




}
