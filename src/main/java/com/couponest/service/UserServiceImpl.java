package com.couponest.service;

import com.couponest.dao.UserDao;
import com.couponest.dao.UserDaoImpl;
import com.couponest.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class UserServiceImpl implements UserService{

    private UserDao userDAO = new UserDaoImpl();

    @Override
    public List<User> getUsers(int id, int page, int count) {
        List<User> users = new ArrayList<>();
        if(0 != id){
            User user = userDAO.getUser(id);
            if(null == user){
                return null;
            }else{
                users.add(user);
            }
        }else{
            users = userDAO.getUsers(page, count);
        }
        return users;
    }

    @Override
    public int addUser(User user) {
        return userDAO.createUser(user);
    }
}
