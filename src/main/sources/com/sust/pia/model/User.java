package com.sust.pia.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Haodong Zhao
 * @Package com.sust.pia.model
 * @Description 用户信息类
 * @Datetime 2019/7/3 10:51
 */


@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Setter
    @Getter
    private Integer id; // 用户id
    @Setter
    @Getter
    private String username; // 用户名
    @Setter
    @Getter
    private String password; // 用户密码
    @Setter
    @Getter
    private String emailAddress; // 用户地址

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
    }

}
