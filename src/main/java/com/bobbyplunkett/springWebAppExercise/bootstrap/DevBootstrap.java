package com.bobbyplunkett.springWebAppExercise.bootstrap;

import com.bobbyplunkett.springWebAppExercise.model.Club;
import com.bobbyplunkett.springWebAppExercise.model.Student;
import com.bobbyplunkett.springWebAppExercise.repositories.ClubRepository;
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

    public DevBootstrap(StudentRepository studentRepository, ClubRepository clubRepository) {
        this.studentRepository = studentRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        /* Students */
        // Tim
        Student tim = new Student("Tim", "Williams", "D");
        // Sam
        Student sam = new Student("Sam", "Brooks", "C");
        // Brittni
        Student brittni = new Student("Brittni", "Brown", "A");
        // Tina
        Student tina = new Student("Tina", "Hemlock", "B");
        // Sal
        Student sal = new Student("Sal", "Holt", "F");
        // Tim
        Student renee = new Student("Renee", "Stevens", "D");

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
        studentRepository.save(tim);
        studentRepository.save(brittni);
        studentRepository.save(tina);
        studentRepository.save(sam);
        studentRepository.save(sal);
        studentRepository.save(renee);

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


}
