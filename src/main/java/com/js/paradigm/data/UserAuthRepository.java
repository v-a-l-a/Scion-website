package com.js.paradigm.data;

import com.js.paradigm.model.User;
import com.js.paradigm.security.MongoUserDetails;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserAuthRepository extends MongoRepository<User, String> {

    Optional<User> findById(final String uname);
    User save(User user);
    boolean existsById(String uname);
}
