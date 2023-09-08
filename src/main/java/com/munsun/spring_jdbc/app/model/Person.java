package com.munsun.spring_jdbc.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "PERSONS")
public class Person {
    @EmbeddedId
    private Info info;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="city_of_living")
    private String city;
}