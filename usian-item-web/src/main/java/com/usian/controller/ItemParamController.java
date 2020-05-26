package com.usian.controller;

import com.usian.feign.ItemServiceFeignClient;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Result selectItemParamByItemCatId(@PathVariable Long itemCatId) {
        List<TbItemParam> tbItemParamList = itemServiceFeignClient.selectItemParamByItemCatId(itemCatId);
        if (tbItemParamList != null && tbItemParamList.size() > 0) {
            return Result.ok(tbItemParamList);
        }
        return Result.error("查无结果");
    }

    /**
     * 分页查询商品规格模板
     *
     * @return
     */
    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "3") Integer rows) {
        PageResult pageResult = itemServiceFeignClient.selectItemParamAll(page, rows);
        if(pageResult.getResult().size()>0){
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }

    /**
     * 添加商品规格模板
     * @param itemCatId
     * @param paramData
     * @return
     */
    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId,String paramData ){
        Integer num=itemServiceFeignClient.insertItemParam(itemCatId,paramData);
        if(num==1){
            return Result.ok("添加成功");
        }
        return Result.error("添加失败");
    }

}
