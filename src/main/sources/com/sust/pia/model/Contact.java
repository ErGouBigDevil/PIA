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
 * @Description 联系人类
 * @Datetime 2019/7/3 10:53
 */

@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Setter
    @Getter
    private Integer contactId; // 联系人信息id
    @Setter
    @Getter
    private Integer userId; // 用户id
    @Setter
    @Getter
    private String name; // 联系人姓名
    @Setter
    @Getter
    private String phone; // 联系人电话
    @Setter
    @Getter
    private String email; // 联系人电子邮件
    @Setter
    @Getter
    private String company; // 联系人公司
    @Setter
    @Getter
    private String address; // 联系人地址

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }
}
