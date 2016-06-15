package com.couponest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by yunpeng on 2016/6/15.
 */
public class ParseRequest {
    public static  Map<String, Object> getRequestObject(HttpServletRequest request) {
        StringBuilder json = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = request.getReader();

            String line = null;
            while((line = reader.readLine()) != null){
                json.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSON.parseObject(json.toString(), new TypeReference<Map<String,Object>>(){});
    }
}
