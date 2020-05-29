package com.usian.controller;


import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.CatNode;
import com.usian.utils.PageResult;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 枫柚素主
 * @version 1.0
 * @date 2020/5/17 16:11
 */

@RestController
@RequestMapping("/service/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * 根据ID查询
     * @param itemId
     * @return
     */
    @RequestMapping("/selectItemInfo")
    public TbItem selectItemInfo(Long itemId){
        return itemService.selectItemInfo(itemId);
    }

    /**
     * 分页查询商品信息
     * @param
     * @return
     */
    @RequestMapping("/selectTbItemAllByPage")
    public PageResult selectTbItemAllByPage(Integer page, long rows){
        return itemService.selectTbItemAllByPage(page,rows);
    }

    /**
     * 添加商品
     * @param tbItem
     */
    @RequestMapping("/insertTbItem")
    public void insertTbItem(@RequestBody TbItem tbItem){

        itemService.insertTbItem(tbItem);
    }

    @RequestMapping("/deleteItemById")
    public void deleteByItemId(@RequestParam Long itemId){
        itemService.deleteByItemId(itemId);
    }



}
