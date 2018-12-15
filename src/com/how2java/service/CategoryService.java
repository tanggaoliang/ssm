package com.how2java.service;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    void add(Category category);

    void update(Category category);

    void delete(Category category);

    Category get(int id);

    void addTwo();

//    int total();

//    List<Category> list(Page page);
}
