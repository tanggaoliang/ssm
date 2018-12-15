package com.how2java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("listCategory")
    public ModelAndView listCategory(Page page) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 6);
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);
        modelAndView.addObject("cs", cs);
        modelAndView.setViewName("listCategory");
        return modelAndView;
    }
    //    public ModelAndView listCategory(Page page) {
//        ModelAndView modelAndView = new ModelAndView();
//        int total = categoryService.total();
//        page.calculateLast(total);
//        List<Category> cs = categoryService.list(page);
//        modelAndView.addObject("cs", cs);
//        modelAndView.setViewName("listCategory");
//        return modelAndView;
//    }

    @RequestMapping("addCategory")
    public ModelAndView addCategory(Category category) {
        categoryService.add(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(Category category) {
        categoryService.delete(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(Category category) {
        category = categoryService.get(category.getId());
        ModelAndView mav = new ModelAndView("editCategory");
        mav.addObject("c", category);
        return mav;
    }

    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category category) {
        categoryService.update(category);
        ModelAndView mav = new ModelAndView("redirect:/listCategory");
        return mav;
    }


}
