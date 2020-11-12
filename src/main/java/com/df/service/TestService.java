package com.df.service;

import com.df.dao.TestDao;
import com.df.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hanyli
 * @date 2020/6/9
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List<Map<String,Object>> query() {
        return testDao.query();
    }
}
