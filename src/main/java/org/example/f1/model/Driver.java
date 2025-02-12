package org.example.f1.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer permanentNumber;
    private Integer totalRaceWins;
}