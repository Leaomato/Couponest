package com.couponest.controller;

import com.couponest.model.BaseRespModel;
import com.couponest.model.RespGetUserModel;
import com.couponest.model.User;
import com.couponest.service.UserService;
import com.couponest.service.UserServiceImpl;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import java.util.List;

import static com.couponest.utils.ParseRequest.getRequestObject;
import static com.couponest.utils.StateStruct.*;

/**
 * Created by yunpengliu on 16-6-13.
 */
public class UserController extends Controller{

    private UserService userService = new UserServiceImpl();

    @Before(GET.class)
    public void get(){
        RespGetUserModel response = new RespGetUserModel(this.getRequest());
        //获取url中的参数
        int id = getPara("id") == null ? 0 : getParaToInt("id");
        int page = getPara("page") == null ? 1 : getParaToInt("page");
        int count = getPara("count") == null ? 2 : getParaToInt("count");

        List<User> users = userService.getUsers(id, page, count);
        if(null == users){
            response.setStateCode(SS_NO_DATA_ERROR);
            response.setStateMsg(SS_NO_DATA_ERROR_);
        }else{
            response.setStateCode(SS_SUCCESS);
            response.setStateMsg(SS_SUCCESS_);
            response.setData(users);
        }

        renderJson(response);

    }

    @Before(POST.class)
    public void add(){
        BaseRespModel response = new BaseRespModel(this.getRequest());

        //获取传递进来的model
        //
        //User user = User.dao._setAttrs(map);
        //dao是全局的，只能查询，不能用来承载数据。上句代码错误。
        User user = new User()._setAttrs(getRequestObject(this.getRequest()));

        int id = userService.addUser(user);
        if(0 == id){
            response.setStateCode(SS_CREATE_USER_ERROR);
            response.setStateMsg(SS_CREATE_USER_ERROR_);
        }else{
            response.setStateCode(SS_SUCCESS);
            response.setStateMsg(SS_SUCCESS_);
            response.setData(id);
        }

        renderJson(response);
    }
}
