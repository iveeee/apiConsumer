package com.api.consumer.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String project;

    @Column(nullable = false)
    private String author;

    public Record() {}

    public Record(String author, String project) {
        this.project = project;
        this.author = author;
    }
}
