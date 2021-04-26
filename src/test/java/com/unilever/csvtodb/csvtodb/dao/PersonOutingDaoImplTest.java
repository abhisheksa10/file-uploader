package com.unilever.csvtodb.csvtodb.dao;

import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;
import com.unilever.csvtodb.csvtodb.repository.PersonOutingRepository;
import com.unilever.csvtodb.csvtodb.shared.TestUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PersonOutingDaoImplTest {

    @TestConfiguration
    static class PersonOutingDaoImplConfiguration {
        @Bean
        public PersonOutingDao personOutingDao() {
            return new PersonOutingDaoImpl();
        }
    }


    @Autowired
    private PersonOutingDao dao;
    @MockBean
    private PersonOutingRepository repository;

    @Test
    public void testSave() {

        when(repository.save(any(PersonOutingEntity.class))).thenReturn(
                TestUtility.getPersonOutingEntity(1, "John", "Amsterdam", "veena restaurant", "restaurant"));
        PersonOutingEntity personOutingEntity = dao.save(
                TestUtility.getPersonOutingEntity(1, "John", "Amsterdam", "veena restaurant", "restaurant"));

        Assert.assertTrue(personOutingEntity.getId() == 1L);
        Assert.assertTrue(personOutingEntity.getLastName().equals("John"));
        Assert.assertTrue(personOutingEntity.getLocation().equals("Amsterdam"));
        Assert.assertTrue(personOutingEntity.getOutletName().equals("veena restaurant"));
        Assert.assertTrue(personOutingEntity.getOutletType().equals("restaurant"));
    }
}