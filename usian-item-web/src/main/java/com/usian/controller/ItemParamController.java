package com.usian.controller;

import com.usian.feign.ItemServiceFeignClient;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/18 0:36
 */
@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {

    @Autowired
    private ItemServiceFeignClient itemServiceFeignClient;

    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable Long itemCatId){
        List<TbItemParam> tbItemParamList=itemServiceFeignClient.selectItemParamByItemCatId(itemCatId);
        if(tbItemParamList!=null&&tbItemParamList.size()>0){
            return Result.ok(tbItemParamList);
        }
        return Result.error("查无结果");
    }
}
