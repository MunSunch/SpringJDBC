package com.munsun.spring_jdbc.app.controllers;

import com.munsun.spring_jdbc.app.dao.PersonRepository;
import com.munsun.spring_jdbc.app.model.Person;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Validated
public class CustomOrderRestController {
    private PersonRepository repository;

    @Secured("ROLE_READ")
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam @NotBlank String city) {
        return repository.execQueryByCity(city);
    }

    @RolesAllowed("WRITE")
    @GetMapping("/persons/by-less-age")
    public List<Person> getPersonByAge(@RequestParam @Positive Integer age) {
        return repository.execQueryByInfoLessThanAgeOrderByAge(age);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/persons/by-name-or-surname")
    public List<Person> getOrderNameByCustomerName(@RequestParam @NotBlank String name,
                                                   @RequestParam @NotBlank String surname)
    {
        return repository.execQueryByInfo_NameOrInfo_Surname(name, surname);
    }

    @PreAuthorize("#username == authentication.name")
    @GetMapping("/persons/get")
    public List<Person> getAll(@RequestParam(name="user") String username) {
        return repository.findAll();
    }
}
