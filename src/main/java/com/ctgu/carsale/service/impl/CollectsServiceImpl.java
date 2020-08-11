package com.ctgu.carsale.service.impl;

import com.ctgu.carsale.entity.Collects;
import com.ctgu.carsale.dao.CollectsDao;
import com.ctgu.carsale.mapper.CollectsMapper;
import com.ctgu.carsale.service.CollectsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Collects)表服务实现类
 *
 * @author makejava
 * @since 2020-08-08 15:21:08
 */
@Service("collectsService")
public class CollectsServiceImpl implements CollectsService {
    @Resource
    private CollectsDao collectsDao;

    @Resource
    CollectsMapper collectsMapper;

//    @Override
//    public List<Integer> collectsList(Collects collects) {
//        return this.collectsDao.collectsList(collects);
//    }

    @Override
    public boolean inCollects(Collects collects) {
        Collects collects1 = this.collectsMapper.inCollects(collects);
        if (collects1 == null) {
            return false;
        }
        return true;
    }

    @Override
    public Collects insertCollects(Collects collects) {
        this.collectsDao.insertCollects(collects);
        return collects;
    }

    @Override
    public boolean remove(Collects collects) {
        return this.collectsDao.remove(collects) > 0;
    }


}