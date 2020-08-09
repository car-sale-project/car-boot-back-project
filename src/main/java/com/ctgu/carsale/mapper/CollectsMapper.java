package com.ctgu.carsale.mapper;

import com.ctgu.carsale.entity.Collects;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectsMapper {
    @Select(" select * from collects where carId = #{carid} and userId = #{userid}")
    Collects inCollects(Collects collects);

}
