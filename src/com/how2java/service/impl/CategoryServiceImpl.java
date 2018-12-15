package com.how2java.service.impl;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryMapper.delete(category.getId());
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }
//    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public void addTwo() {
        Category category=new Category();
        category.setName("1111113");
        categoryMapper.add(category);
        Category category1=new Category();
        category1.setName("00000000000000");
        categoryMapper.add(category1);

    }
    //    @Override
//    public int total() {
//        return categoryMapper.total();
//    }

//    @Override
//    public List<Category> list(Page page) {
//        return categoryMapper.list(page);
//    }
}
