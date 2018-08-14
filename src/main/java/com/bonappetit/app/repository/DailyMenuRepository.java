package com.bonappetit.app.repository;

import com.bonappetit.app.model.menuSection.DailyMenu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMenuRepository extends MongoRepository<DailyMenu,String>,CustomDailyMenuRepository {
}
