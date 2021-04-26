package com.unilever.csvtodb.csvtodb.repository;

import com.unilever.csvtodb.csvtodb.entity.PersonOutingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonOutingRepository extends JpaRepository<PersonOutingEntity, String> {

//    PersonOutingEntity findById(String id);
}
