package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.OrderUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderUserRepository extends MongoRepository<OrderUser,String> {
}
