package com.stackroute.userservice.repo;

import com.stackroute.userservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailIgnoreCase(String username);
}
