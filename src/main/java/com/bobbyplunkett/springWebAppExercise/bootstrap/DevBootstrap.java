package com.bobbyplunkett.springWebAppExercise.bootstrap;

import com.bobbyplunkett.springWebAppExercise.model.Club;
import com.bobbyplunkett.springWebAppExercise.model.ContactInfo;
import com.bobbyplunkett.springWebAppExercise.model.Student;
import com.bobbyplunkett.springWebAppExercise.repositories.ClubRepository;
import com.bobbyplunkett.springWebAppExercise.repositories.ContactInfoRepository;
import com.bobbyplunkett.springWebAppExercise.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Initializes and bootstraps data to storage
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 11:00 PM
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private StudentRepository studentRepository;
    private ClubRepository clubRepository;
    private ContactInfoRepository contactInfoRepository;

    public DevBootstrap(StudentRepository studentRepository, ClubRepository clubRepository, ContactInfoRepository contactInfoRepository) {
        this.studentRepository = studentRepository;
        this.clubRepository = clubRepository;
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        /* Students */
        // Tim
        Student tim = new Student(new ContactInfo("Tim", "Williams", 21), "D");
        // Sam
        Student sam = new Student(new ContactInfo("Sam", "Brooks", 20), "C");
        // Brittni
        Student brittni = new Student(new ContactInfo("Brittni", "Brown", 23), "A");
        // Tina
        Student tina = new Student(new ContactInfo("Tina", "Hemlock", 19), "B");
        // Sal
        Student sal = new Student(new ContactInfo("Sal", "Holt", 25), "F");
        // Tim
        Student renee = new Student(new ContactInfo("Renee", "Stevens", 22), "D");

        /* Clubs */
        Club debate = new Club("Debate Club", "2016-02-21", "We win any argument.");
        Club computer = new Club("Computer Club", "2017-10-04", "Anything from code to PC builds.");

        /* Club Associations */

        // Debate Club
        addClub(tim, debate);
        addClub(brittni, debate);
        addClub(tina, debate);

        // Computer Club
        addClub(sam, computer);
        addClub(sal, computer);
        addClub(renee, computer);

        // Save students to repository
        addStudentToRepo(tim);
        addStudentToRepo(brittni);
        addStudentToRepo(tina);
        addStudentToRepo(sam);
        addStudentToRepo(sal);
        addStudentToRepo(renee);

        // Save clubs to repository
        clubRepository.save(debate);
        clubRepository.save(computer);
    }

    /**
     * A helper method which adds both {@link Student} and {@link Club} to each others collections.
     * @param student the student being added to the club
     * @param club the club to add student too
     */
    private void addClub(Student student, Club club) {
        student.getClubs().add(club);
        club.getStudents().add(student);
    }

    /**
     * A helper method which adds {@link Student} and {@link ContactInfo} to their associated repositories.
     * @param student to be added to the repository
     */
    private void addStudentToRepo(Student student) {
        contactInfoRepository.save(student.getContactInfo());
        studentRepository.save(student);
    }


}
