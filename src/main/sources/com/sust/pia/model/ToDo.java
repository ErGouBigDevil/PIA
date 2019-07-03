package com.sust.pia.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author Haodong Zhao
 * @Package com.sust.pia.model
 * @Description 日常事务持久化类
 * @Date 2019/7/3 10:53
 */

@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @Setter
    @Getter
    private Integer userId;
    @Setter
    @Getter
    private String title;   // 事务标题
    @Setter
    @Getter
    private Date deadline;  // 事务截止时间
    @Setter
    @Getter
    private String site;    // 事务发生地点
    @Setter
    @Getter
    private String note;    // 事务备注

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
    }


}
