package com.bobbyplunkett.springWebAppExercise.repositories;

import com.bobbyplunkett.springWebAppExercise.model.Club;
import org.springframework.data.repository.CrudRepository;

/**
 * A extension of {@link CrudRepository} store types of {@link Club} indexed
 * by entry ID.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 10:57 PM
 */
public interface ClubRepository extends CrudRepository<Club, Long> {
}
