package com.stackroute.botservice.repository;


import com.stackroute.botservice.domain.UserQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QueryRespository extends MongoRepository<UserQuery, String> {
}
