package com.example.demo.db;

import com.example.demo.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String number;
    private String group1;
   @OneToMany(mappedBy = "student")
    private Set<ScoreRow> scores;

    public StudentRow(String name, String number, String group1) {
        this.name = name;
        this.number = number;
        this.group1 = group1;
    }

    public StudentRow() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGroup1(String group) {
        this.group1 = group;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getGroup1() {
        return group1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Student toStudent() {
        return new Student(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getGroup1());
    }

    public Set<ScoreRow> getScores() {
        return scores;
    }
}