package com.ctgu.carsale.dao;

import com.ctgu.carsale.entity.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Car)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-07 21:34:43
 */
public interface CarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param carid 主键
     * @return 实例对象
     */
    Car queryById(Integer carid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Car> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param car 实例对象
     * @return 对象列表
     */
    List<Car> queryAll(Car car);

    /**
     * 新增数据
     *
     * @param car 实例对象
     * @return 影响行数
     */
    int insert(Car car);

    /**
     * 修改数据
     *
     * @param car 实例对象
     * @return 影响行数
     */
    int update(Car car);

    /**
     * 通过主键删除数据
     *
     * @param carid 主键
     * @return 影响行数
     */
    int deleteById(Integer carid);

    /**查询所有车辆信息**/
    List<Car> getCarList();

    /**搜索框查询符合条件的车**/
    List<Car> search(String carname);

    /**分页查询所有用户**/
    List<Car> getAllByPage();

    /**通过id查询多条数据
     * @param ids**/
    List<Car> queryByIds(List<Integer> ids);
}