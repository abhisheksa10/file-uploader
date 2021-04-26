package com.unilever.csvtodb.csvtodb.service;

import java.util.List;

import com.unilever.csvtodb.csvtodb.dao.PersonOutingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;
import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;
import com.unilever.csvtodb.csvtodb.exception.InvalidRequestException;

@Service
public class PersonOutingServiceImpl implements PersonOutingService {

    @Autowired
    private PersonOutingDao personOutingDao;

    /**
     * Saves the person details specified to the database.
     *
     * @param personOutingDTOs the person details to be saved
     */
    @Override
    public void savePersonDetails(final List<PersonOutingDTO> personOutingDTOs) {
        if(personOutingDTOs.isEmpty()){
            throw new InvalidRequestException("Person details are empty. Cannot save");
        }

        personOutingDTOs.forEach(personOutingDTO ->  personOutingDao.save(dtoToEntity(personOutingDTO)));
    }

    /**
     * Converts DTO to entity object.
     *
     * @param personOutingDTO the DTO to be converted
     * @return the converted entity object
     */
    private PersonOutingEntity dtoToEntity(final PersonOutingDTO personOutingDTO) {

        if(isInvalidPersonDetails(personOutingDTO)) {
            throw new InvalidRequestException("Required fields in the CSV are empty. Cannot save");
        }

        return PersonOutingEntity.builder()
                .id(personOutingDTO.getId())
                .lastName(personOutingDTO.getLastName())
                .location(personOutingDTO.getLocation())
                .outletName(personOutingDTO.getOutletName())
                .outletType(personOutingDTO.getOutletType())
                .build();
    }

    /**
     * Validates the specified person details to see if it is invalid.
     *
     * @param personOutingDTO
     * @return true if the specified details are valid, false otherwise
     */
    private boolean isInvalidPersonDetails(final PersonOutingDTO personOutingDTO) {

        return personOutingDTO == null ||
                personOutingDTO.getLastName() == null ||
                personOutingDTO.getLastName().isEmpty() ||
                personOutingDTO.getLocation() == null ||
                personOutingDTO.getLocation().isEmpty() ||
                personOutingDTO.getOutletName() == null ||
                personOutingDTO.getOutletName().isEmpty() ||
                personOutingDTO.getOutletType() == null ||
                personOutingDTO.getOutletType().isEmpty();
    }
}
