package com.example.wtwback.repositories;

import com.example.wtwback.entities.User;
import com.example.wtwback.entities.projections.IUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT users.id AS userId, users.name AS userName, users.last_name AS userLastName, "+
            "users.email AS userEmail, users.password AS userPassword FROM users " +
            "WHERE users.email = :email AND users.password = :password ;", nativeQuery = true)
    IUserProjection findUserByEmailAndPassword(String email, String password);
}
