package com.ctgu.carsale.service.impl;

import com.ctgu.carsale.entity.Admin;
import com.ctgu.carsale.dao.AdminDao;
import com.ctgu.carsale.mapper.AdminMapper;
import com.ctgu.carsale.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-08-08 11:51:07
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin chechout(Admin admin) {
        return this.adminMapper.chechout(admin);
    }
}