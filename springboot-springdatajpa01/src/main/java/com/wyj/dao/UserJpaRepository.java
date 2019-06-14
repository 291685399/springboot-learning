package com.wyj.dao;

import com.wyj.entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 不仅继承啦 PagingAndSortingRepository 同时继承了 QueryByExampleExecutor（示例匹配器）
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {
}
