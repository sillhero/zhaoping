package com.mjc.javaee.Dao;

import com.mjc.javaee.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}20:16
 */
public interface UserDao extends JpaRepository<User,String> {

    @Query(value = "select PassWord from User where UserName = ?1",nativeQuery = true)
    String getPasswordByUserName(String userName);

    @Query(value = "select * from User where userName = ?1",nativeQuery = true)
    User getByUserName(String name);
}
