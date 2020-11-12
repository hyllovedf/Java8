package com.df.dao;

import com.df.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {
    List<Map<String,Object>> query();
}
