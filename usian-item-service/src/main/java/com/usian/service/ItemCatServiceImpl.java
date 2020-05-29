package com.usian.service;


import com.usian.mapper.TbItemCatMapper;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemCatExample;
import com.usian.utils.CatNode;
import com.usian.utils.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 枫柚素主
 * @version 1.0
 * @date 2020/5/17 16:20
 */

@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andParentIdEqualTo(id);
        return tbItemCatMapper.selectByExample(tbItemCatExample);
    }

    @Override
    public CatResult selectItemCategoryAll() {
        //1查詢商品类别
        List  catList = getCatList(0L);
        CatResult result = new CatResult();
        result.setData(catList);
        return result;
    }

    private List<CatNode> getCatList(Long parentId) {
        //2 把查询结果装载到List<CatNode>,并且只装18次
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(example);
        List catNodes = new ArrayList();
        int count=0;
        for (TbItemCat cat : tbItemCatList) {
           if(cat.getIsParent()){
               CatNode catNode = new CatNode();
               catNode.setName(cat.getName());
               catNode.setItem(getCatList(cat.getId()));
               catNodes.add(catNode);
               count++;
               if (count==18){
                    break;
               }
           }else {

               catNodes.add(cat.getName());
           }
       }
        return catNodes;
    }

}
