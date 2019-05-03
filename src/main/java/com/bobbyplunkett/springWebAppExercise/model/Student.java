package com.bobbyplunkett.springWebAppExercise.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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
    private String grade;

    @OneToOne
    private ContactInfo contactInfo;

    @ManyToMany(mappedBy = "students")
    private Set<Club> clubs = new HashSet<>();

    public Student() {
    }

    public Student(ContactInfo contactInfo, String grade) {
        this.contactInfo = contactInfo;
        this.grade = grade;
    }

    public Student(ContactInfo contactInfo, String grade, Set<Club> clubs) {
        this.contactInfo = contactInfo;
        this.clubs = clubs;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + contactInfo.getFirstName() + '\'' +
                ", lastName='" + contactInfo.getLastName() + '\'' +
                ", age='" + contactInfo.getAge() + '\'' +
                ", grade=" + grade +
                ", clubs=" + clubs +
                '}';
    }
}
