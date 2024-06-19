package com.adeshcoder.Backingfor30mincoding.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="guide1")
@Data

@NoArgsConstructor

public class Guide1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="topic")
    private String topic;



    @Column(name = "link")
    private  String link;

    public Guide1(String topic, String link) {
        this.topic = topic;
        this.link = link;
    }
}
