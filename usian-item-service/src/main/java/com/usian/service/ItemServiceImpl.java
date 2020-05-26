package com.usian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.mapper.TbItemMapper;
import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemExample;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author 枫柚素主
 * @version 1.0
 * @date 2020/5/17 16:20
 */

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem selectItemInfo(Long itemId) {


        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public PageResult selectTbItemAllByPage(Integer page, Long rows) {
        PageHelper.startPage(page, rows.intValue());
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> PageInfo = new PageInfo<>(tbItemList);
        PageResult pageResult = new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setTotalPage(Long.valueOf(PageInfo.getPages()));
        pageResult.setResult(PageInfo.getList());
        return pageResult;
    }

    @Override
    public void insertTbItem(TbItem tbItem) {

        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItemMapper.insertSelective(tbItem);
    }

    @Override
    public void deleteByItemId(Long itemId) {
        tbItemMapper.deleteByPrimaryKey(itemId);
    }

}
