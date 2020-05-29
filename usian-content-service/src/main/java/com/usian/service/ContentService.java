package com.usian.service;

import com.usian.pojo.TbContent;
import com.usian.utils.AdNode;
import com.usian.utils.PageResult;
import com.usian.utils.Result;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 10:37
 */
public interface ContentService {
    PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId);

    Integer insertTbContent(TbContent tbContent);

    Integer deleteContentByIds(Long ids);

    List<AdNode> selectFrontendContentByAD();
}
