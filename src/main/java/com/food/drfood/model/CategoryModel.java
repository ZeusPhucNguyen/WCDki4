package com.food.drfood.model;

import com.food.drfood.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category obj);

    List<Category> findAll();

    Category findById(int id);

    Category update(int id, Category updateObj);

    boolean delete(int id);
}
