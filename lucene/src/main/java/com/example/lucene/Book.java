package com.example.lucene;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sheledon
 */
@Setter
@Getter
@ToString
public class Book {
    private Integer id;
    private String name;
    private Float price;
    private String pic;
    private String description;
}
