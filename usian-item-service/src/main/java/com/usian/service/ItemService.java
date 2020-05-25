package com.usian.service;

import com.github.pagehelper.Page;
import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;
import com.usian.utils.Result;

/**
 * @author 枫柚素主
 * @version 1.0
 * @date 2020/5/17 16:18
 */
public interface ItemService {

    TbItem selectItemInfo(Long itemId);

    PageResult selectTbItemAllByPage(Integer page, Long rows);
}
