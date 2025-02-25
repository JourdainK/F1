package org.example.f1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name ="continent", schema="public")
public class Continent {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;

    private String code;
    private String name;
    private String demonym;
}
