package com.unilever.csvtodb.csvtodb.shared;

import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;
import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;

import java.util.ArrayList;
import java.util.List;

public class TestUtility {

    public static PersonOutingEntity getPersonOutingEntity(long id, String lastName, String location, String outletName, String outletType) {

        PersonOutingEntity entity = new PersonOutingEntity();
        entity.setId(id);
        entity.setLastName(lastName);
        entity.setLocation(location);
        entity.setOutletName(outletName);
        entity.setOutletType(outletType);

        return entity;
    }

    public static PersonOutingDTO getPersonOutingDTO(long id, String lastName, String location, String outletName, String outletType) {
        PersonOutingDTO dto = new PersonOutingDTO();
        dto.setId(id);
        dto.setLastName(lastName);
        dto.setLocation(location);
        dto.setOutletName(outletName);
        dto.setOutletType(outletType);

        return dto;
    }

    public static List<PersonOutingDTO> getPersonOutingDTOs() {
        List<PersonOutingDTO> personOutingDTOs = new ArrayList<>();

        personOutingDTOs.add(getPersonOutingDTO(1, "John", "Amsterdam", "veena restaurant", "restaurant"));

        return personOutingDTOs;
    }
}
