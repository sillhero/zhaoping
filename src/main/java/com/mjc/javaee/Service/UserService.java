package com.mjc.javaee.Service;

import com.mjc.javaee.Dao.UserDao;
import com.mjc.javaee.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName Recruitment
 * @Description: TODO
 * @date ${DAT}20:17
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(User user){
        userDao.save(user);
    }

    public List<User> selectAllUser(){
        return userDao.findAll();
    }

    public void deleteByID(String id){
        userDao.deleteById(id);
    }

    public void update(User user){
        userDao.save(user);
    }

    public String getPasswordByUserName(String name){
        return userDao.getPasswordByUserName(name);
    }

    public User getByUserName(String userName){
        return userDao.getByUserName(userName);
    }
}
