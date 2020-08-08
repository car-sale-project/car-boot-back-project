package com.ctgu.carsale.service;

import com.ctgu.carsale.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-08-08 11:51:07
 */
@Service
public interface AdminService {
    Admin chechout(Admin admin);
}