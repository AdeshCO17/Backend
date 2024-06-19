package com.adeshcoder.Backingfor30mincoding.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="/guide")
@Data

@NoArgsConstructor

public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="topic")
    private String topic;



    @Column(name = "link")
    private  String link;

    public Guide(String topic, String link) {
        this.topic = topic;
        this.link = link;
    }
}
