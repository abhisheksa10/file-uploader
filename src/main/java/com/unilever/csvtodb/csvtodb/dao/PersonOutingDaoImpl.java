package com.unilever.csvtodb.csvtodb.dao;

import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;
import com.unilever.csvtodb.csvtodb.repository.PersonOutingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonOutingDaoImpl implements PersonOutingDao {

    @Autowired
    private PersonOutingRepository personOutingRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonOutingDaoImpl.class);

    @Override
    public PersonOutingEntity save(PersonOutingEntity personOutingEntity) {
        return personOutingRepository.save(personOutingEntity);
    }
}
