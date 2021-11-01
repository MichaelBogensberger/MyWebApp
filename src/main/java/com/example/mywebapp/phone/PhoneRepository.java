package com.example.mywebapp.phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PhoneRepository extends CrudRepository<Phone, Integer> {


    @Query(value = "SELECT p.number FROM phone p where p.owner_id = :id", nativeQuery = true)
    List<String> findNumberByUserId(@Param("id") Integer id);

    @Query(value = "SELECT p.anbieter FROM phone p where p.owner_id = :id", nativeQuery = true)
    List<String> findAnbieterByUserId(@Param("id") Integer id);


    @Query(value = "SELECT p.id FROM phone p where p.owner_id = :id", nativeQuery = true)
    List<String> findIdByUserId(@Param("id") Integer id);









}
