package com.unilever.csvtodb.csvtodb.service;


import com.unilever.csvtodb.csvtodb.dao.PersonOutingDao;
import com.unilever.csvtodb.csvtodb.dto.PersonOutingDTO;
import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;
import com.unilever.csvtodb.csvtodb.exception.InvalidRequestException;
import com.unilever.csvtodb.csvtodb.shared.TestUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonOutingServiceImplTest {

    @TestConfiguration
    static class PersonOutingServiceImplConfiguration {
        @Bean
        public PersonOutingService personOutingServiceImpl() {
            return new PersonOutingServiceImpl();
        }
    }

    @Autowired
    private PersonOutingService service;

    @MockBean
    private PersonOutingDao personOutingDao;


    @Test(expected = InvalidRequestException.class)
    public void testSaveEmptyPersonDetails() {
        service.savePersonDetails(Collections.emptyList());
    }

    @Test
    public void testSavePersonDetails() {
        final PersonOutingEntity personOutingEntity = TestUtility.getPersonOutingEntity(1, "John", "Amsterdam", "veena restaurant", "restaurant");
        when(personOutingDao.save(any(PersonOutingEntity.class))).thenReturn(personOutingEntity);
        service.savePersonDetails(TestUtility.getPersonOutingDTOs());
        verify(personOutingDao, times(1)).save(personOutingEntity);
    }

    @Test(expected = InvalidRequestException.class)
    public void testSavePersonDetailsWithoutLastName() {
        final PersonOutingEntity personOutingEntity = TestUtility.getPersonOutingEntity(1, null, "Amsterdam", "veena restaurant", "restaurant");
        when(personOutingDao.save(any(PersonOutingEntity.class))).thenReturn(personOutingEntity);
        List<PersonOutingDTO> dtos = TestUtility.getPersonOutingDTOs();
        dtos.forEach(dto -> dto.setLastName(null));

        service.savePersonDetails(dtos);
    }

}