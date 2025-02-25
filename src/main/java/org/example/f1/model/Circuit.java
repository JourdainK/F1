package org.example.f1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "circuit", schema="public")
public class Circuit {

    @Id
    @GeneratedValue(generator =  "uuid")
    @Column(name = "id")
    private String id;

    private String name;

    @Column(name = "full_name")
    private String fullName;

    private String type;
    private String direction;

    @Column(name = "place_name")
    private String placeName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer turns;

    @Column(name = "total_races_held")
    private Integer totalRacesHeld;

    @Column(name = "image_url")
    private String imageUrl;  // New field for image URL
}
