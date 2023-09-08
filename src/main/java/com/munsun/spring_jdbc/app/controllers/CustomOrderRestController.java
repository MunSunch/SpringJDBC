package com.munsun.spring_jdbc.app.controllers;

import com.munsun.spring_jdbc.app.dao.PersonDao;
import com.munsun.spring_jdbc.app.model.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Validated
public class CustomOrderRestController {
    private PersonDao repository;

    @GetMapping("/persons/by-city")
    public List<Person> getOrderNameByCustomerName(@RequestParam @NotBlank String city) {
        return repository.getPersonsByCity(city);
    }
}
