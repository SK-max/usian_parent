package com.usian.service;

import com.usian.mapper.TbContentCategoryMapper;
import com.usian.pojo.TbContentCategory;
import com.usian.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/26 1:27
 */
@Service
@Transactional
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> selectContentCategoryByParentId(Long id) {
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbContentCategory> categoryList = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        return categoryList;
    }

    @Override
    public Integer insertContentCategory(TbContentCategory tbContentCategory) {
        //1 添加内容分类
        Date date = new Date();
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setStatus(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(date);
        tbContentCategory.setUpdated(date);
        Integer insertSelective = tbContentCategoryMapper.insertSelective(tbContentCategory);

        //2 如果他爹不是爹 要把他爹改成爹
        //2.1查询他爹
        int i=0;
        TbContentCategory parentContentCategory = tbContentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
        if(!parentContentCategory.getIsParent()){
            parentContentCategory.setIsParent(true);
            parentContentCategory.setUpdated(new Date());
             i = tbContentCategoryMapper.updateByPrimaryKeySelective(parentContentCategory);
        }

        return insertSelective+i;
    }

    @Override
    public Integer deleteContentCategoryById(Long categoryId) {
        //1如果有子节点 直接返回0
        TbContentCategory contentCategory = tbContentCategoryMapper.selectByPrimaryKey(categoryId);
        if(contentCategory.getIsParent()){
        return 0;
        }
        //2删除节点
        tbContentCategoryMapper.deleteByPrimaryKey(categoryId);
        //3 如果他爹不是爹
        TbContentCategoryExample categoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria  exampleCriteria= categoryExample.createCriteria();
        exampleCriteria.andParentIdEqualTo(categoryId);
        List<TbContentCategory> cList = tbContentCategoryMapper.selectByExample(categoryExample);
        if(cList.size()==0||cList==null){
            TbContentCategory parentcontentCategory = new TbContentCategory();
            parentcontentCategory.setId(contentCategory.getParentId());
            parentcontentCategory.setIsParent(false);
            parentcontentCategory.setUpdated(new Date());
            tbContentCategoryMapper.updateByPrimaryKeySelective(parentcontentCategory);
        }
        return 200;
    }

    @Override
    public Integer updateContentCategory(TbContentCategory tbContentCategory) {
        tbContentCategory.setUpdated(new Date());
        return tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
    }


}
