package com.couponest.service;

import com.couponest.model.User;

import java.util.List;

/**
 * Created by yunpeng on 2016/6/15.
 */
public interface UserService {
    List<User> getUsers(int id, int page, int count);

    int addUser(User user);
}
