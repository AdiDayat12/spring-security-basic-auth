package com.nseva.basic_auth.repos;

import com.nseva.basic_auth.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
//    @Query("SELECT u FROM User u WHERE u.email = :email")
//    Optional<User> findByEmail (@Param("email") String email);
    Optional<User> findByEmail (String email);
}
