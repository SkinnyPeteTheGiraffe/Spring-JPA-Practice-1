package com.bobbyplunkett.springWebAppExercise.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A Club data model.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 05/02/2019
 */
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String foundedDate; // yyyy-mm-dd
    private String description;

    @ManyToMany
    @JoinTable(name = "student_club", joinColumns = @JoinColumn(name = "club_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();

    public Club() {
    }

    public Club(String name, String foundedDate, String description) {
        this.name = name;
        this.foundedDate = foundedDate;
        this.description = description;
    }

    public Club(String name, String foundedDate, String description, Set<Student> students) {
        this.name = name;
        this.foundedDate = foundedDate;
        this.description = description;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
