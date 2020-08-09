package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.Admin;
import com.ctgu.carsale.entity.Car;
import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.entity.User;
import com.ctgu.carsale.service.AdminService;
import com.ctgu.carsale.service.CarService;
import com.ctgu.carsale.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-08-08 11:51:07
 */
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Resource
    private CarService carService;
    /**管理员登录校验**/
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public JsonBean login(Admin admin){
        JsonBean jsonBean = new JsonBean();
        Admin admin1 = this.adminService.chechout(admin);
        if (admin1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户名或密码错误");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("登录成功");
        return jsonBean;
    }

    /**分页查询所有用户**/
    @GetMapping("get_all_user_by_page")
    @ResponseBody
    public PageInfo<User> findAllUserByPage(@RequestParam(value = "page",required = true) int page, @RequestParam(value = "offset",required = true) int offset){
        return this.userService.getAllByPage(page,offset);
    }

    /**分页查询所有汽车**/
    @GetMapping("get_all_car_by_page")
    @ResponseBody
    public PageInfo<Car> findAllCarByPage(@RequestParam(value = "page",required = true) int page, @RequestParam(value = "offset",required = true) int offset){
        return this.carService.getAllByPage(page,offset);
    }

    /**管理员封禁用户**/
    @RequestMapping(value = "lock",method = RequestMethod.POST)
    public JsonBean lock(User user){
        JsonBean jsonBean = new JsonBean();
        User user1 = this.userService.lock(user);
        if (user1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("封禁失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("封禁成功");
        return jsonBean;
    }

    /**管理员解封用户**/
    @RequestMapping(value = "unlock",method = RequestMethod.POST)
    public JsonBean unlock(User user){
        JsonBean jsonBean = new JsonBean();
        User user1 = this.userService.unlock(user);
        if (user1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("解封失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("解封成功");
        return jsonBean;
    }

    /**添加车辆**/
    @RequestMapping(value = "insert_car",method = RequestMethod.POST)
    public JsonBean insert(Car car){
        JsonBean jsonBean = new JsonBean();
        Car car1 = this.carService.insert(car);
        if (car1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("添加失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("添加成功");
        return jsonBean;
    }

    /**从数据库删除车辆**/
    @RequestMapping(value = "delete_by_id",method = RequestMethod.POST)
    public JsonBean delete(Car car){
        JsonBean jsonBean = new JsonBean();
        if (!this.carService.deleteById(car.getCarid())) {
            jsonBean.setStatus(-1);
            jsonBean.setMsg("删除失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("删除成功");
        return jsonBean;
    }

    /**修改车辆信息**/
    @RequestMapping(value = "update_car",method = RequestMethod.POST)
    public JsonBean update(Car car){
        JsonBean jsonBean = new JsonBean();
        Car car1 = this.carService.update(car);
        if (car1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("修改失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("修改成功");
        return jsonBean;
    }

}