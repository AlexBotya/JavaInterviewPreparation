package ru.gb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "mark")
    private int mark;

}
