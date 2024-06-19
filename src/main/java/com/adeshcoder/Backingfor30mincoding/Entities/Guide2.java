package com.adeshcoder.Backingfor30mincoding.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="guide2")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Guide2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="topic")
    private String topic;



    @Column(name = "link")
    private  String link;

    public Guide2(String topic, String link) {
        this.topic = topic;
        this.link = link;
    }
}
