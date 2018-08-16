package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.DailyMenu;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyMenuRepository extends MongoRepository<DailyMenu,String>,CustomDailyMenuRepository {
    List<DailyMenu> findAll(Sort sort);
}
