package com.levysales.FinanceAPI.api.controller;

import com.levysales.FinanceAPI.api.converter.OutgoingFromDTOConverter;
import com.levysales.FinanceAPI.api.converter.OutgoingToDTOConverter;
import com.levysales.FinanceAPI.api.model.IncomeOutput;
import com.levysales.FinanceAPI.api.model.Input.OutgoingInput;
import com.levysales.FinanceAPI.api.model.OutgoingOutput;
import com.levysales.FinanceAPI.domain.exceptions.ReleaseNotFoundException;
import com.levysales.FinanceAPI.domain.model.Outgoing;
import com.levysales.FinanceAPI.domain.repository.OutgoingRepository;
import com.levysales.FinanceAPI.domain.service.OutgoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/despesas")
public class OutgoingController {

    @Autowired
    private OutgoingRepository outgoingRepository;

    @Autowired
    private OutgoingService outgoingService;

    @Autowired
    private OutgoingToDTOConverter outgoingToDTOConverter;

    @Autowired
    private OutgoingFromDTOConverter outgoingFromDTOConverter;

    @GetMapping
    public List<OutgoingOutput> listAll() {
        List<Outgoing> outgoingList = outgoingRepository.findAll();
        return outgoingToDTOConverter.toCollectionDTO(outgoingList);
    }

    @GetMapping("/{outgoingId}")
    public OutgoingOutput findById(@PathVariable Long outgoingId) {
        Outgoing outgoing = outgoingService.findOrFail(outgoingId);
        return outgoingToDTOConverter.toDTO(outgoing);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutgoingOutput toAdd(@RequestBody @Valid OutgoingInput outgoingInput) {
        Outgoing outgoing = outgoingFromDTOConverter.fromDTO(outgoingInput);
        return outgoingToDTOConverter.toDTO(outgoingService.toSave(outgoing));
    }

    @PostMapping("/{outgoingId}")
    public OutgoingOutput toUpdate(@PathVariable Long outgoingId, @RequestBody @Valid OutgoingInput outgoingInput) {
        try {
            Outgoing outgoing = outgoingService.findOrFail(outgoingId);
            outgoingFromDTOConverter.copyToDomain(outgoingInput, outgoing);

            return outgoingToDTOConverter.toDTO(outgoing);
        } catch (ReleaseNotFoundException e) {
            throw new ReleaseNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{outgoingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void toDelete(@PathVariable Long outgoingId) {
        outgoingService.toDelete(outgoingId);
    }


}
