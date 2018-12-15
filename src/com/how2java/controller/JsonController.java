package com.how2java.controller;

import com.alibaba.fastjson.JSONObject;
import com.how2java.pojo.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class JsonController {
    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM received the json from browser and convert it to Category " + category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
        Category category = new Category();
        category.setId(100);
        category.setName("the 100 category ");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", JSONObject.toJSON(category));
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setId(i);
            category.setName("category json" + i);
            cs.add(category);
        }
        return JSONObject.toJSON(cs).toString();
    }

}
