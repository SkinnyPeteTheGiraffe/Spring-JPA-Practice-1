package com.bobbyplunkett.springWebAppExercise.repositories;

import com.bobbyplunkett.springWebAppExercise.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * A extension of {@link CrudRepository} store types of {@link Student} indexed
 * by entry ID.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 10:55 PM
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
