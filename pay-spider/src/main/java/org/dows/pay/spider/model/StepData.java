package org.dows.pay.spider.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class StepData {

    private Integer step;
    private String seed;
    private List<Map<String, Object>> datas;

    public void addData(Map<String, Object> data) {
        datas.add(data);
    }

    public <T> T toObject(Class<T> tClass) {
        T t = null;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("{}实例化异常", tClass);
        }
        return t;
    }
}
