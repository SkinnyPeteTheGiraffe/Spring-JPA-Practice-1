package com.bobbyplunkett.springWebAppExercise.repositories;

import com.bobbyplunkett.springWebAppExercise.model.ContactInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * A extension of {@link CrudRepository} store types of {@link ContactInfo} indexed
 * by entry ID.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 10:57 PM
 */
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {
}
