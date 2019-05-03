package com.bobbyplunkett.springWebAppExercise.model;

import com.bobbyplunkett.springWebAppExercise.model.data.Grades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A Student data model.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 05/02/2019
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Grades grade;

    @ManyToMany(mappedBy = "students")
    private Set<Club> clubs = new HashSet<>();

    public Student() {
    }

    public Student(String firstName, String lastName, Grades grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public Student(String firstName, String lastName, Grades grade, Set<Club> clubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clubs = clubs;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
}
