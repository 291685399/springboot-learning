package com.wyj.dao;

import com.wyj.entity.po.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 他是具有分页和排序的功能 同时他继承啦 CrudRepository
 */
public interface UserPageRepository extends PagingAndSortingRepository<User,Long> {
}
