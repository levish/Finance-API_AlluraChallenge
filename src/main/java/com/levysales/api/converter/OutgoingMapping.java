package com.levysales.api.converter;

import com.levysales.api.model.Input.OutgoingInput;
import com.levysales.api.model.OutgoingOutput;
import com.levysales.domain.model.Outgoing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OutgoingMapping {

    OutgoingInput toDomain(Outgoing outgoing);

    OutgoingOutput toDTO(Outgoing outgoing);


}
