package br.com.api.myfirstwebapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.myfirstwebapplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(@Param("id") long id);
    
}