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
 * @Description 密码管理类
 * @Datetime 2019/7/3 10:54
 */

@AllArgsConstructor
@NoArgsConstructor
public class Pass {
    @Setter
    @Getter
    private Integer passId; // 密码id
    @Setter
    @Getter
    private Integer userId; // 用户id
    @Setter
    @Getter
    private String website;   // 网站名称
    @Setter
    @Getter
    private String username;  // 该网站用户名
    @Setter
    @Getter
    private String password;  // 该网站密码

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }
}
