package com.munsun.spring_jdbc.app.dao;

import com.munsun.spring_jdbc.app.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDao {
    @PersistenceContext
    private EntityManager manager;

    public List<Person> getPersonsByCity(String city) {
        return manager.createQuery("select p from Person p", Person.class)
                .getResultList().stream()
                .filter(x -> city.equals(x.getCity()))
                .collect(Collectors.toList());
    }
}
