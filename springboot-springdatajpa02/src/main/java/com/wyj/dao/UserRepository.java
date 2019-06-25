package com.wyj.dao;

import com.wyj.entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 可以快速自定义查询方法
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * And
     * 对应sql：where name=? and age=?
     *
     * @param name
     * @param age
     * @return
     */
    public List<User> findByNameAndAge(String name, int age);

    /**
     * Or
     * 对应sql：where name=? or age=?
     *
     * @param name
     * @param age
     * @return
     */
    public List<User> findByNameOrAge(String name, int age);

    /**
     * Is
     * 对应sql：where name=?
     *
     * @param name
     * @return
     */
    public List<User> findByNameIs(String name);

    /**
     * Equals
     * 对应sql：where name=?
     *
     * @param name
     * @return
     */
    public List<User> findByNameEquals(String name);

    /**
     * Between
     * 对应sql：where age between ? and ?
     *
     * @param LittleAge
     * @param bigAge
     * @return
     */
    public List<User> findByAgeBetween(int LittleAge, int bigAge);

    /**
     * LessThan
     * 对应sql：where age<?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeLessThan(int age);

    /**
     * AgeLessThanEqual
     * 对应sql：where age<=?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeLessThanEqual(int age);

    /**
     * LessThan
     * 对应sql：where age>?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeGreaterThan(int age);

    /**
     * GreaterThanEqual
     * 对应sql：where age>=?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeGreaterThanEqual(int age);

    /**
     * After
     * 对应sql：where age>?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeAfter(int age);

    /**
     * Before
     * 对应sql：where age<?
     *
     * @param age
     * @return
     */
    public List<User> findByAgeBefore(int age);

    /**
     * IsNull（不用参数）
     * 对应sql：where name is null
     *
     * @return
     */
    public List<User> findByNameIsNull();

    /**
     * IsNotNull（不用参数）
     * 对应sql：where name is not null
     *
     * @return
     */
    public List<User> findByNameIsNotNull();

    /**
     * NotNull（不用参数）
     * 对应sql：where name is not null
     *
     * @return
     */
    public List<User> findByNameNotNull();

    /**
     * Not
     * 对应sql：where name <>?
     *
     * @param name
     * @return
     */
    public List<User> findByNameNot(String name);

    /**
     * In
     * 对应sql：where age in (?)
     *
     * @param ageList
     * @return
     */
    public List<User> findByAgeIn(List<Integer> ageList);

    /**
     * NotIn
     * 对应sql：where age not in (?)
     *
     * @param ageList
     * @return
     */
    public List<User> findByAgeNotIn(List<Integer> ageList);

    /**
     * NotLike
     * 对应sql：where name not like ?
     *
     * @param name
     * @return
     */
    public List<User> findByNameNotLike(String name);

    /**
     * Like
     * 对应sql：where name like ?
     *
     * @param name
     * @return
     */
    public List<User> findByNameLike(String name);

    /**
     * StartingWith
     * 对应sql：where name like '?%'
     *
     * @param name
     * @return
     */
    public List<User> findByNameStartingWith(String name);

    /**
     * EndingWith
     * 对应sql：where name like '%?'
     *
     * @param name
     * @return
     */
    public List<User> findByNameEndingWith(String name);

    /**
     * Containing
     * 对应sql：where name like '%?%'
     *
     * @param name
     * @return
     */
    public List<User> findByNameContaining(String name);

    /**
     * Contains
     * 对应sql：where name like '%?%'
     *
     * @param name
     * @return
     */
    public List<User> findByNameContains(String name);

    /**
     * OrderBy
     * 对应sql：order by age desc
     * desc：降序，asc：升序
     *
     * @return
     */
    public List<User> findByOrderByAgeDesc();

    /**
     * Ignorecase
     * 对应sql：where UPPER(name) = UPPER(?)
     *
     * @return
     */
    public List<User> findByNameIgnoreCase(String name);

}
