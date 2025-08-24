package com.rith.borgoappapi.service;

import com.rith.borgoappapi.model.MenuItem;
import com.rith.borgoappapi.model.Category;

import java.util.List;
import java.util.Optional;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    Optional<MenuItem> getMenuItemById(Long id);
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItemDetails);
    void deleteMenuItem(Long id);
    List<MenuItem> getMenuItemsByCategory(Category category);
    List<MenuItem> getMenuItemsByCategoryId(Long categoryId);
}
