package com.couponest.model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class RespGetUserModel extends BaseRespModel<List<User>>{
    public RespGetUserModel(HttpServletRequest request) {
        super(request);
    }
}
