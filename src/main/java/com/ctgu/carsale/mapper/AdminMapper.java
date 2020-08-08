package com.ctgu.carsale.mapper;

import com.ctgu.carsale.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where adminId=#{adminid} and adminPw=#{adminpw}")
    Admin chechout(Admin admin);
}
