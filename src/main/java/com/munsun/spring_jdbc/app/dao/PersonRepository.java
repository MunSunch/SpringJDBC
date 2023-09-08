package com.munsun.spring_jdbc.app.dao;

import com.munsun.spring_jdbc.app.model.Info;
import com.munsun.spring_jdbc.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Info> {
    @Query("""
        select p 
        from Person p 
        where p.city = :city
    """)
    List<Person> execQueryByCity(@Param("city") String city);

    @Query("""
        select p 
        from Person p 
        where p.info.age < :age
        order by p.info.age asc
    """)
    List<Person> execQueryByInfoLessThanAgeOrderByAge(@Param("age") Integer age);

    @Query("""
        select p 
        from Person p
        where p.info.name = :name or p.info.surname = :surname
    """)
    List<Person> execQueryByInfo_NameOrInfo_Surname(@Param("name") String name,
                                                    @Param("surname") String surname);



//    List<Person> findPersonByCity(String city);
//    List<Person> findPersonByInfo_AgeLessThanOrderByInfo_AgeAsc(Integer age);
//    List<Person> findPersonByInfo_NameOrInfo_Surname(String name, String surname);
}
