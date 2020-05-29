package com.usian.service;

import com.usian.pojo.TbItemCat;
import com.usian.utils.CatResult;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/17 16:18
 */
public interface ItemCatService {


    List<TbItemCat> selectItemCategoryByParentId(Long id);

    CatResult selectItemCategoryAll();
}
