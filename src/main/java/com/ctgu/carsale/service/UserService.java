package com.ctgu.carsale.service;

import com.ctgu.carsale.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-08-07 11:58:45
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    User queryById(Long userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Long userid);

    /**登录验证**/
    User checkUser(User user);

    /**查询是否已经注册**/
    User queryByPhone(User user);

    /**获取所有用户**/
    List<User> getUserList();

    /**分页查询所有用户**/
    PageInfo<User> getAllByPage(int page,int offset);

    /**封禁用户**/
    User lock(User user);

    /**解封用户**/
    User unlock(User user);
}