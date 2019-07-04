package com.sust.pia.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author Haodong Zhao
 * @Package com.sust.pia.model
 * @Description 用户信息持久化类
 * @Datetime 2019/7/3 10:51
 */


@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Setter
    @Getter
    private Integer id;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String emailAddress;
//    @Setter
//    @Getter
//    private List<Contact> contacts;
//    @Setter
//    @Getter
//    private List<ToDo> toDoList;
//    @Setter
//    @Getter
//    private List<Pass> passList;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
    }

}
