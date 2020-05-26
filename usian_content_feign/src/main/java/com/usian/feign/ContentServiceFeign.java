package com.usian.feign;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;

import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 1:16
 */

@FeignClient("usian-content-service")
public interface ContentServiceFeign {


    @RequestMapping("/service/content/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long id);

    @RequestMapping("/service/content/insertContentCategory")
    Integer insertContentCategory(TbContentCategory tbContentCategory);

    @RequestMapping("/service/content/deleteContentCategoryById")
    Integer deleteContentCategoryById(@RequestParam Long cateGoryId);

    @RequestMapping("/service/content/updateContentCategory")
    Integer updateContentCategory(@RequestBody TbContentCategory tbContentCategory);

    @RequestMapping("/service/content/selectTbContentAllByCategoryId")
    PageResult selectTbContentAllByCategoryId(@RequestParam Integer page,
                                              @RequestParam Integer rows,
                                              @RequestParam Long categoryId);
    @RequestMapping("/service/content/insertTbContent")
    Integer insertTbContent(@RequestBody TbContent tbContent);

    @RequestMapping("/service/content/deleteContentByIds")
    Integer deleteContentByIds(@RequestParam Long ids);
}
