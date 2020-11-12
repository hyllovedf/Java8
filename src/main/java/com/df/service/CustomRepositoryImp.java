package com.df.service;

import com.df.common.CustomRepository;
import com.df.entity.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author hanyli
 * @date 2020/11/10
 */
public class CustomRepositoryImp<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {
    private EntityManager entityManager;

    public CustomRepositoryImp(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }
    @Override
    public void doSomething() {

    }
}
