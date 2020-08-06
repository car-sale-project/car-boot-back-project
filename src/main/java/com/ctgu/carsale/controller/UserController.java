package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.entity.User;
import com.ctgu.carsale.service.UserService;
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

    /**
     * 登录
     *
     * @param username password
     * @return JsonBean
     */
    @PostMapping("login.do")
    public JsonBean login(@RequestParam("username") String username,
                          @RequestParam("password") String password , HttpSession session){
        JsonBean jsonBean = new JsonBean();
        if(username == null || password == null ||
                username.isEmpty() || password.isEmpty()){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户名或密码为空，请重新输入");
            return jsonBean;
        }
        User user = this.userService.queryByName(username);
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
        return jsonBean;
    }
}