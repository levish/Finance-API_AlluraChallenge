package com.levysales.FinanceAPI.domain.service;

import com.levysales.FinanceAPI.domain.exceptions.ReleaseNotFoundException;
import com.levysales.FinanceAPI.domain.model.Outgoing;
import com.levysales.FinanceAPI.domain.repository.OutgoingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutgoingService {

    public static final String OUTGOING_NOTFOUND = "Despesa não encontrada";

    @Autowired
    private OutgoingRepository outgoingRepository;

    @Transactional
    public Outgoing toSave(Outgoing outgoing) {
        return outgoingRepository.save(outgoing);
    }

    @Transactional
    public void toDelete(Long outgoingId) {
        try {
            outgoingRepository.deleteById(outgoingId);
            outgoingRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new ReleaseNotFoundException(String.format(OUTGOING_NOTFOUND, outgoingId));
        }
    }

    public Outgoing findOrFail(Long outgoingId) {
        return outgoingRepository.findById(outgoingId).orElseThrow(
                () -> new ReleaseNotFoundException(String.format(OUTGOING_NOTFOUND, outgoingId)));
    }


}
