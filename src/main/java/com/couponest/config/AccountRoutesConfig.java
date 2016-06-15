package com.couponest.config;

import com.couponest.controller.UserController;
import com.jfinal.config.Routes;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class AccountRoutesConfig extends Routes{
    @Override
    public void config() {
        add("/user", UserController.class);
    }
}
