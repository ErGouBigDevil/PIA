package com.sust.pia.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Package com.sust.pia.model
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 18:49
 */

@AllArgsConstructor
@NoArgsConstructor
public class DataList<T> {
    @Setter
    @Getter
    private int total;
    @Setter
    @Getter
    private List<T> rows;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
    }
}
