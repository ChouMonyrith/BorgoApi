package com.rith.borgoappapi.service;

import com.rith.borgoappapi.model.MenuItem;
import com.rith.borgoappapi.model.Category;
import com.rith.borgoappapi.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItemDetails) {
        return menuItemRepository.findById(id)
                .map(menuItem -> {
                    menuItem.setName(menuItemDetails.getName());
                    menuItem.setDescription(menuItemDetails.getDescription());
                    menuItem.setPrice(menuItemDetails.getPrice());
                    menuItem.setImageUrl(menuItemDetails.getImageUrl());
                    menuItem.setAvailable(menuItemDetails.isAvailable());
                    menuItem.setCategory(menuItemDetails.getCategory());
                    return menuItemRepository.save(menuItem);
                }).orElseThrow(() -> new RuntimeException("Menu Item not found with id " + id)); // Or a custom exception
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getMenuItemsByCategory(Category category) {
        return menuItemRepository.findByCategory(category);
    }

    @Override
    public List<MenuItem> getMenuItemsByCategoryId(Long categoryId) {
        return menuItemRepository.findByCategoryId(categoryId);
    }
}
