package org.example.f1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name ="country", schema="public")
public class Country {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;

    private String alpha2_code;
    private String alpha3_code;
    private String name;
    private String demonym;

    @ManyToOne
    @JoinColumn(name="continent_id")
    private Continent continentId;

}
