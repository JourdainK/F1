package org.example.f1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name="constructor", schema="public")
public class Constructor {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name ="id")
    private String id;

    private String name;

    @Column(name="full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "best_championship_position")
    private Integer bestChampionshipPosition;

    @Column(name = "total_championship_wins")
    private Integer totalChampionshipWins;

    @Column(name = "total_race_wins")
    private Integer totalRaceWins;

    @Column(name = "total_podiums")
    private Integer totalPodiums;

    @Column(name = "total_fastest_laps")
    private Integer totalFastestLaps;

}
