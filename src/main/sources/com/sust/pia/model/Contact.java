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
 * @Description 联系人持久化类
 * @Date 2019/7/3 10:53
 */

@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Setter
    @Getter
    private String userId;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String phone;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String company;
    @Setter
    @Getter
    private String address;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }
}
