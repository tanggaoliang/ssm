package com.how2java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class RestfulCategoryController {
    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView listCategory(Page page) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 5);
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);
        modelAndView.addObject("cs", cs);
        modelAndView.setViewName("restfulListCategory");
        return modelAndView;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ModelAndView addCategory(Category category) {
        System.out.println("category.getName():" + category.getName());
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteCategory(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory(Category category) {
        Category c = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("restfulEditCategory");
        mav.addObject("c", c);
        return mav;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ModelAndView updateCategory(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/category");
        return mav;
    }


}
