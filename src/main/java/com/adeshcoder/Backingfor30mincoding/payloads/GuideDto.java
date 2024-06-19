package com.adeshcoder.Backingfor30mincoding.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideDto {

    private Integer id;


    private String topic;


    private  String link;
}
