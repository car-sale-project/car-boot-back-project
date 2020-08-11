package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.entity.User;
import com.ctgu.carsale.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    /** 登录接口 **/
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public JsonBean login(User user, HttpSession session){
//        System.out.println(user.getUsername()+" "+user.getUserpassword());
        JsonBean jsonBean = new JsonBean();
        User existUser = this.userService.checkUser(user);
        if(existUser == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户名或密码错误，请重新输入");
            return jsonBean;
        }
        else {
            if (existUser.getDeltag()==0){
                jsonBean.setStatus(-1);
                jsonBean.setMsg("该用户已被封禁，请联系管理员解封");
                return jsonBean;
            }
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("登录成功");
        jsonBean.setObj(existUser);
        session.setAttribute("user",existUser);

//        User user1 = (User)session.getAttribute("user");
        return jsonBean;
    }

    /**注册接口**/
    @Transactional
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public JsonBean register(User user){
        JsonBean jsonBean = new JsonBean();
        User existUser = this.userService.queryByPhone(user);
        if(existUser != null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("该用户已注册，请勿重复注册");
            return jsonBean;
        }
        this.userService.insert(user);
        jsonBean.setStatus(0);
        jsonBean.setMsg("注册成功");
        return jsonBean;
    }

    /**登录状态获取个人信息**/
    @RequestMapping(value = "get_user_info",method = RequestMethod.POST)
    public JsonBean getUserInfo(HttpSession session){
        JsonBean jsonBean = new JsonBean();
        User user = (User)session.getAttribute("user");
        if(user == null){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("用户未登录");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("请求成功");
        jsonBean.setObj(user);
        return jsonBean;
    }

    /**修改个人信息**/
    @Transactional
    @RequestMapping(value = "update_information",method = RequestMethod.POST)
    public User update_information(User user){
        return this.userService.update(user);
    }

    /**退出登录**/
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public int logout(HttpSession session){
        session.removeAttribute("user");
        return 0;
    }

    /**分页查询所有用户**/
    @RequestMapping(value = "get_all_by_page",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<User> findAllByPage(@RequestParam(value = "page") int page, @RequestParam(value = "offset") int offset){
        return this.userService.getAllByPage(page,offset);
    }

}