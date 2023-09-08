package com.munsun.spring_jdbc.app.controllers;

import com.munsun.spring_jdbc.app.dao.PersonRepository;
import com.munsun.spring_jdbc.app.model.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@Validated
public class CustomOrderRestController {
    private PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Person> getOrderNameByCustomerName(@RequestParam @NotBlank String city) {
        return repository.findPersonByCity(city);
    }

    @GetMapping("/persons/by-less-age")
    public List<Person> getPersonByAge(@RequestParam @Positive Integer age) {
        return repository.findPersonByInfo_AgeLessThanOrderByInfo_AgeAsc(age);
    }

    @GetMapping("/persons/by-name-or-surname")
    public List<Person> getOrderNameByCustomerName(@RequestParam @NotBlank String name,
                                                       @RequestParam @NotBlank String surname)
    {
        return repository.findPersonByInfo_NameOrInfo_Surname(name, surname);
    }
}
