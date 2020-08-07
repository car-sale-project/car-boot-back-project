package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.Car;
import com.ctgu.carsale.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Car)表控制层
 *
 * @author makejava
 * @since 2020-08-07 21:34:43
 */
@RestController
@RequestMapping("api/v1/car")
public class CarController {
    /**
     * 服务对象
     */
    @Resource
    private CarService carService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Car selectOne(Integer id) {
        return this.carService.queryById(id);
    }

    /**查询所有车辆信息**/
    @GetMapping("get_all_cars")
    public List<Car> getAll(){
        return this.carService.getCarList();
    }

    /**通过车名或品牌搜索**/
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public List<Car> search(@RequestParam("carname") String carname){
//        System.out.println(carname);
        return this.carService.search(carname);
    }


}