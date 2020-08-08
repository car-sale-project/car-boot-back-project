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


}