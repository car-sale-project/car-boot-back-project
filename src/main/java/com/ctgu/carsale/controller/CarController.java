package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.Car;
import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.service.CarService;
import com.github.pagehelper.PageInfo;
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

    @GetMapping("detail")
    public Car selectOne(Car car) {
        return this.carService.queryById(car.getCarid());
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

    /**分页查询所有汽车**/
    @GetMapping("get_all_by_page")
    @ResponseBody
    public PageInfo<Car> findAllByPage(@RequestParam(value = "page",required = true) int page, @RequestParam(value = "offset",required = true) int offset){
        return this.carService.getAllByPage(page,offset);
    }

}