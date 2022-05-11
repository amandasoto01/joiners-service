package com.endava.joiners.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "joiners")
@Data
@NoArgsConstructor
public class Joiner {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "identification_number", unique = true)
    private int identificationNumber;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String stack;
    @Column
    private String role;
    @Column(name = "english_level")
    private String englishLevel;
    @Column(name = "domain_experience")
    private String domainExperience;
}
