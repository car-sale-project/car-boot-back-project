package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.entity.User;
import com.ctgu.carsale.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-08-07 11:58:45
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public JsonBean login(User user){
//        System.out.println(user.getUsername()+" "+user.getUserpassword());
        JsonBean jsonBean = new JsonBean();
        User existUser = this.userService.queryByName(user);
        if(existUser == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("登录失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("登录成功");
        jsonBean.setObj(existUser);
        return jsonBean;
    }
}