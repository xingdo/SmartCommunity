package com.demo.base;

import com.demo.utils.PageList;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Transactional
    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        baseMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void update(T t) {
        baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public T selectOne(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public PageList<T> queryPage(BaseQuery query) {
        Page<T> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到分页后的总数据
        baseMapper.queryPage(query);
        return new PageList<>(objects.getTotal(), objects.getResult());
    }
}
