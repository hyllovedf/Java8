package com.df.common;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author hanyli
 * @date 2020/11/10
 */
@NoRepositoryBean
public interface CustomRepository<T,ID>extends PagingAndSortingRepository<T,ID> {
    void doSomething();
}
