package com.unilever.csvtodb.csvtodb.service;

import java.util.List;

import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;

public interface PersonOutingService {

    void savePersonDetails(final List<PersonOutingDTO> personOutingDTOs);
}
