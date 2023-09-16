package com.munsun.spring_jdbc.app.model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "account_ID", referencedColumnName = "id")
    private Account account;
}