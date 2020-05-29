package com.usian.service;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 1:26
 */
public interface ContentCategoryService {

    List<TbContentCategory> selectContentCategoryByParentId(Long id);

    Integer insertContentCategory(TbContentCategory tbContentCategory);

    Integer deleteContentCategoryById(Long categoryId);

    Integer updateContentCategory(TbContentCategory tbContentCategory);


}
