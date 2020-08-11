package com.ctgu.carsale.dao;

import com.ctgu.carsale.entity.Collects;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Collects)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-08 15:21:08
 */
public interface CollectsDao {
//    List<Integer> collectsList(Collects collects);
    int insertCollects(Collects collects);
    int remove(Collects collects);
    Collects collectsListDetail(Collects collects);
}