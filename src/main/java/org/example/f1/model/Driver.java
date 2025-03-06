package org.example.f1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

@Data
@Entity
@ToString
@Table(name = "driver", schema = "public")
public class Driver {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;

    private String name;
    private String firstName;
    private String lastName;
    private String fullName;
    private String abbreviation;

    @Column(name = "country_of_birth_country_id")
    private String birthCountry;

    @Nullable
    private Integer permanentNumber;

    @Column(name="total_race_wins")
    private Integer totalRaceWins;

    @Column(name = "total_podiums")
    private Integer totalPodiums;

    @Column(name = "total_championship_wins")
    private Integer totalChampionshipWins;
}