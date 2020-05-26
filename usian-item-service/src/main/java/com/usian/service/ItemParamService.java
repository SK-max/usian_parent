package com.usian.service;

import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;


import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/18 22:46
 */
public interface ItemParamService {

    List<TbItemParam> selectItemParamByItemCatId(Long itemCatId);

    PageResult selectItemParamAll(Integer page, Integer rows);

    Integer insertItemParam(Long itemCatId, String patamDate);
}
