package com.ctgu.carsale.mapper;

import com.ctgu.carsale.entity.Collects;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectsMapper {
    @Select(" select * from collects where carId = #{carid} and userId = #{userid}")
    Collects inCollects(Collects collects);

    @Select(" select * from collects where userId = #{userid}")
    List<Collects> userInCollects(Collects collects);


}
