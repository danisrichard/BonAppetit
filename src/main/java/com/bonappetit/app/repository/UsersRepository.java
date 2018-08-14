package com.bonappetit.app.repository;

import com.bonappetit.app.model.userSection.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users,String> {
    Optional<Users> findByUserName(String userName);

}
