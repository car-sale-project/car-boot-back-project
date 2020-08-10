package com.ctgu.carsale.service.impl;

import com.ctgu.carsale.entity.Car;
import com.ctgu.carsale.dao.CarDao;
import com.ctgu.carsale.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Car)表服务实现类
 *
 * @author makejava
 * @since 2020-08-07 21:34:43
 */
@Service("carService")
public class CarServiceImpl implements CarService {
    @Resource
    private CarDao carDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carid 主键
     * @return 实例对象
     */
    @Override
    public Car queryById(Integer carid) {
        return this.carDao.queryById(carid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Car> queryAllByLimit(int offset, int limit) {
        return this.carDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @Override
    public Car insert(Car car) {
        this.carDao.insert(car);
        return car;
    }

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 实例对象
     */
    @Override
    public Car update(Car car) {
        this.carDao.update(car);
        return this.queryById(car.getCarid());
    }

    /**
     * 通过主键删除数据
     *
     * @param carid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carid) {
        return this.carDao.deleteById(carid) > 0;
    }

    /**获取所有汽车信息**/
    @Override
    public List<Car> getCarList() {
        return this.carDao.getCarList();
    }

    /**搜索框搜索**/
    @Override
    public List<Car> search(String carname) {
        return this.carDao.search(carname);
    }

    /**分页查询所有**/
    @Override
    public PageInfo<Car> getAllByPage(int page, int offset) {
        PageHelper.startPage(page, offset);
        List<Car> all = this.carDao.getAllByPage();
        return new PageInfo<Car>(all);
    }

    @Override
    public List<Car> queryByIds(List<Integer> ids) {
        return this.carDao.queryByIds(ids);
    }
}