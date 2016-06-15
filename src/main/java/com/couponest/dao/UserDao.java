package com.couponest.dao;

import com.couponest.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yunpeng on 2016/6/15.
 */
public interface UserDao {
    User getUser(int id);

    List<User> getUsers(int page, int count);

    int createUser(User user);
}
