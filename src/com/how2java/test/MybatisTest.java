package com.how2java.test;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.service.impl.CategoryServiceImpl;
import com.how2java.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    CategoryService categoryService;

    @Test
    public void testTransaction() {
        categoryService.addTwo();
    }

    //    @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("Category" + i);
            categoryMapper.add(category);
        }
    }

//    @Test
//    public void testTotal() {
//        int total = categoryMapper.total();
//        System.out.println(total);
//    }

//    @Test
//    public void testList() {
//        Page p = new Page();
//        p.setStart(1);
//        p.setCount(5);
//        List<Category> cs = categoryMapper.list();
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//    }
}
