package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.entity.User;
import com.ctgu.carsale.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-08-06 13:51:29
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
    public User selectOne(String id) {
        return this.userService.queryById(id);
    }

    @RequestMapping("test")
    public String getData() {
        return "Hello";
    }

    @RequestMapping("test1")
    public void getData(String username) {
        System.out.println(username);
    }

    /**
     * 登录
     *
     * @param user 用户实例
     * @return JsonBean
     */
    @RequestMapping("login")
    public JsonBean login(User user, HttpSession session){
        System.out.println(user.getUsername());
        JsonBean jsonBean = new JsonBean();
        String username = user.getUsername();
        String password = user.getPassword();
        if(username == null || password == null ||
                username.isEmpty() || password.isEmpty()){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户名或密码为空，请重新输入");
            return jsonBean;
        }
        User user1 = this.userService.queryByName(username);
        if(user == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("该用户未注册");
            return jsonBean;
        }
        else if(!user.getPassword().equals(password)){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("密码错误");
            return jsonBean;
        }
        session.setAttribute("user",user.getUsername());
        jsonBean.setStatus(0);
        jsonBean.setObj(user);
        jsonBean.setMsg("登录成功");
        System.out.println("登录成功");
        return jsonBean;

    }

    /**
     * 注册
     *
     * @param user 用户对象
     * @return JsonBean
     */
    @PostMapping("register.do")
    public JsonBean register(@ModelAttribute User user){
        JsonBean jsonBean = new JsonBean();
        User user1 = this.userService.queryByName(user.getUsername());
        if(user1 == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户名已注册");
            return jsonBean;
        }

        return jsonBean;
    }
}