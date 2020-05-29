package com.usian.controller;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;

import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 1:22
 */
@RestController
@RequestMapping("/service/content")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentService;

    @RequestMapping("/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(Long id){
        return contentService.selectContentCategoryByParentId(id);
    }

    @RequestMapping("/insertContentCategory")
   public Integer insertContentCategory(@RequestBody TbContentCategory tbContentCategory){
        return contentService.insertContentCategory(tbContentCategory);
    };

    @RequestMapping("/deleteContentCategoryById")
   public Integer deleteContentCategoryById(@RequestParam Long categoryId){
        return contentService.deleteContentCategoryById(categoryId);
    };

    @RequestMapping("/updateContentCategory")
   public Integer updateContentCategory( TbContentCategory tbContentCategory){
        return contentService.updateContentCategory(tbContentCategory);
    };

}
