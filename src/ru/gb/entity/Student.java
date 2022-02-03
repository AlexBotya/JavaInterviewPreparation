package ru.gb.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Data

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator")
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "mark")
    private int mark;

}
