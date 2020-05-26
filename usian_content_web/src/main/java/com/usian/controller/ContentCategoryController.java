package com.usian.controller;

import com.usian.feign.ContentServiceFeign;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 1:08
 */

@RestController
@RequestMapping("/backend/content")
public class ContentCategoryController {

    @Autowired
    private ContentServiceFeign contentServiceFeign;

    @RequestMapping("/selectContentCategoryByParentId")
    public Result selectContentCategoryByParentId(@RequestParam(defaultValue = "0") Long id) {
        List<TbContentCategory> tbContentCategoryList = contentServiceFeign.selectContentCategoryByParentId(id);
        if (tbContentCategoryList.size() > 0) {
            return Result.ok();
        }
        return Result.error("查无结果");
    }

    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(TbContentCategory tbContentCategory) {
        Integer insertContent = contentServiceFeign.insertContentCategory(tbContentCategory);
        if (insertContent != null) {
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    @RequestMapping("/deleteContentCategoryById")
    public Result deleteContentCategoryById(Long cateGoryId) {
        Integer status = contentServiceFeign.deleteContentCategoryById(cateGoryId);
        if(status==200){
            return Result.ok();
        }
        return Result.error("删除失败");
    }

    @RequestMapping("/updateContentCategory")
    public Result updateContentCategory(@RequestBody TbContentCategory tbContentCategory){
       Integer updateContentCategory =contentServiceFeign.updateContentCategory(tbContentCategory);

        if (updateContentCategory != null) {
            return Result.ok();
        }
        return Result.error("修改失败");
    }



}
