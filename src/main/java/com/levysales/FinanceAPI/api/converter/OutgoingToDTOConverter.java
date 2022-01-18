package com.levysales.FinanceAPI.api.converter;


import com.levysales.FinanceAPI.api.model.OutgoingOutput;
import com.levysales.FinanceAPI.domain.model.Outgoing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutgoingToDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OutgoingOutput toDTO(Outgoing outgoing) {
        return modelMapper.map(outgoing, OutgoingOutput.class);
    }

    public List<OutgoingOutput> toCollectionDTO(List<Outgoing> outgoingList) {
        return outgoingList.stream()
                .map(outgoing -> toDTO(outgoing))
                .collect(Collectors.toList());
    }


}
