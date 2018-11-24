package com.js.paradigm.data;

import com.js.paradigm.model.UserRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserAuthRepository extends MongoRepository<UserRecord, String> {

    Optional<UserRecord> findById(final String uname);
    UserRecord save(UserRecord userRecord);
    boolean existsById(String uname);
}
