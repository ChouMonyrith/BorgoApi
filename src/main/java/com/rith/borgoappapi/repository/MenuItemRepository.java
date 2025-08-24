package com.rith.borgoappapi.repository;

import com.rith.borgoappapi.model.MenuItem;
import com.rith.borgoappapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(Category category);
    
    @Query("SELECT m FROM MenuItem m WHERE m.category.categoryId = :categoryId")
    List<MenuItem> findByCategoryId(@Param("categoryId") Long categoryId);
}
