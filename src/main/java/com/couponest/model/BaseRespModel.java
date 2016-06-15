package com.couponest.model;

import javax.servlet.http.HttpServletRequest;

import static com.couponest.utils.StateStruct.SS_UNKNOWN_ERROR;
import static com.couponest.utils.StateStruct.SS_UNKNOWN_ERROR_;
import static javafx.scene.input.KeyCode.T;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class BaseRespModel<T> {
    private int stateCode;

    private String stateMsg;

    private String href;

    private T data;

    public BaseRespModel(HttpServletRequest request){
        try{
            href = request.getRequestURL().toString();
        }catch (Exception ex){
            href = "";
        }
        this.stateCode = SS_UNKNOWN_ERROR;
        this.stateMsg = SS_UNKNOWN_ERROR_;
    }
    private BaseRespModel(){}

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
