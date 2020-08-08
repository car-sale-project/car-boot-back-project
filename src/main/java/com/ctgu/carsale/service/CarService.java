package com.ctgu.carsale.service;

import com.ctgu.carsale.entity.Car;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Car)表服务接口
 *
 * @author makejava
 * @since 2020-08-07 21:34:43
 */
@Service
public interface CarService {

    /**
     * 通过ID查询单条数据
     *
     * @param carid 主键
     * @return 实例对象
     */
    Car queryById(Integer carid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Car> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    Car insert(Car car);

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    Car update(Car car);

    /**
     * 通过主键删除数据
     *
     * @param carid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carid);

    /**查询所有车辆信息**/
    List<Car> getCarList();

    /**搜索框查询符合条件的车**/
    List<Car> search(String carname);

    PageInfo<Car> getAllByPage(int page, int offset);
}