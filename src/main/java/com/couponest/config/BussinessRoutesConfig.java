package com.couponest.config;

import com.couponest.controller.DummyController;
import com.jfinal.config.Routes;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class BussinessRoutesConfig extends Routes{
    @Override
    public void config() {
        add("/", DummyController.class);
    }
}
