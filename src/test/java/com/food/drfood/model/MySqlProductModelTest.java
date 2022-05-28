package com.food.drfood.model;

import com.food.drfood.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySqlProductModelTest {
    private ProductModel productModel;
    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("BurgerBear1");
        product.setPrice(100000);
        product.setDescription("Lorem ipsum");
        product.setDetail("Lorem ipsum");
        product.setThumbnail("Lorem ipsum");
        productModel.save(product);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}