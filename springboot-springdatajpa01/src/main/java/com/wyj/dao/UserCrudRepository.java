package com.wyj.dao;

import com.wyj.entity.po.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 具有增删改查的一些基本功能
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {
}
