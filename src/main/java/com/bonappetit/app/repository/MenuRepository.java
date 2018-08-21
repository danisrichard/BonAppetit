package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends MongoRepository<Menu,String>,CustomMenuRepository {

    Optional<Menu> findById(String id);

}
