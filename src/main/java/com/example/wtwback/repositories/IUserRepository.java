package com.example.wtwback.repositories;

import com.example.wtwback.entities.User;
import com.example.wtwback.entities.projections.UserProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    @Query("{ 'email' : ?0, 'password' : ?1 }")
    UserProjection findByEmailAndPassword(String email, String password);
}
