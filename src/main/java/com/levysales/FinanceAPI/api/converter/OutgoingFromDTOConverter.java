package com.levysales.FinanceAPI.api.converter;


import com.levysales.FinanceAPI.api.model.Input.OutgoingInput;
import com.levysales.FinanceAPI.domain.model.Outgoing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutgoingFromDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Outgoing fromDTO(OutgoingInput outgoingInput) {
        return modelMapper.map(outgoingInput, Outgoing.class);
    }

    public List<Outgoing> toCollectionDTO(List<OutgoingInput> outgoingInputList) {
        return outgoingInputList.stream()
                .map(outgoing -> fromDTO(outgoing))
                .collect(Collectors.toList());
    }

    public void copyToDomain(OutgoingInput outgoingInput, Outgoing outgoing) {
        modelMapper.map(outgoingInput, outgoing);
    }

}
