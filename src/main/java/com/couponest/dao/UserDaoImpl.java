package com.couponest.dao;

import com.couponest.model.User;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.couponest.utils.ParseRequest.getRequestObject;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser(int id) {
        return User.dao.findById(id);
    }

    @Override
    public List<User> getUsers(int page, int count) {
//        Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user where sex=? and age>?", 1, 18);
        return User.dao.paginate(page, count, "select *", "from user").getList();
    }

    @Override
    public int createUser(User user) {
        if(user.save()){
            return user.getInt("id");
        }else{
            return 0;
        }
    }
}
