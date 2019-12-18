package com.paprika.utils;

import cn.hutool.json.JSONObject;
import com.paprika.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author adam
 * @date 2019/5/14
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
public class SecurityUtils {
    public static UserDetails getUserDetails() {
        UserDetails userDetails;
        try {
            userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BadRequestException(HttpStatus.UNAUTHORIZED, "登录状态过期");
        }
        return userDetails;
    }

    /**
     * 获取系统用户名称
     * @return 系统用户名称
     */
    public static String getUsername(){
        Object obj = getUserDetails();
        return new JSONObject(obj).get("username", String.class);
    }

    /**
     * 获取系统用户id
     * @return 系统用户id
     */
    public static Long getUserId(){
        Object obj = getUserDetails();
        return new JSONObject(obj).get("id", Long.class);
    }
}
