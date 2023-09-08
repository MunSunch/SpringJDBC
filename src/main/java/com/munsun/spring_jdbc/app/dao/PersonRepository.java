package com.munsun.spring_jdbc.app.dao;

import com.munsun.spring_jdbc.app.model.Info;
import com.munsun.spring_jdbc.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Info> {
    List<Person> findPersonByCity(String city);
}
