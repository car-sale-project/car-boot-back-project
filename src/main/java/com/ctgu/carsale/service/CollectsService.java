package com.ctgu.carsale.service;

import com.ctgu.carsale.entity.Collects;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * (Collects)表服务接口
 *
 * @author makejava
 * @since 2020-08-08 15:21:08
 */
@Service
public interface CollectsService {
    List<Integer> collectsList(Collects collects);
    boolean inCollects(Collects collects);
    Collects insertCollects(Collects collects);
    boolean remove(Collects collects);
}