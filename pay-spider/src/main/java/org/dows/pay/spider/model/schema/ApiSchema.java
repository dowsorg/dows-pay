package org.dows.pay.spider.model.schema;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class ApiSchema {

    private String method;
    private String httpMethod;
    private String url;
    private String descr;

    // api模块
    private String moudle;

    // api || rest interface
//    private String apiName;
    private String apiPath;
    private String apiPkg;
    private String clazz;
    private String explain;

    private List<FieldSchema> input;

    private List<FieldSchema> output;

    private static Map<String, Field> fieldMap = new ConcurrentHashMap<>();

    static {
        fieldMap.putAll(Arrays.stream(ApiSchema.class.getDeclaredFields()).collect(Collectors.toMap(f -> f.getName(), Function.identity())));
    }

    public ApiSchema() {

    }



    public Map<String,List<FieldSchema>> getRequest() {
        Map<String,List<FieldSchema>> resquestMap = new HashMap<>();
        String resquestName = StrUtil.upperFirst(method) + "Request";
        resquestMap.put(resquestName,input);
        return resquestMap;
    }

    public Map<String,List<FieldSchema>> getResponse() {
        Map<String,List<FieldSchema>> resquestMapMap = new HashMap<>();
        String responseName = StrUtil.upperFirst(method) + "Response";
        resquestMapMap.put(responseName,output);
        return resquestMapMap;
    }

    /**
     *
     * @param map
     */
    public ApiSchema(Map<String, Object> map) {
        map.forEach((k, v) -> {
            Field field = fieldMap.get(k);
            if (field != null) {
                field.setAccessible(true);
                try {
                    field.set(this, v);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public String getUrl() {
        return url.split(" ")[0];
    }

    public String getHttpMethod() {
        return url.split(" ")[1];
    }

    public void setApiPath(String root) {
        this.apiPath = root + "/src/main/java/" + this.getApiPkg().replaceAll("\\.", "/");
    }

    public String getDescr(){
        if(StrUtil.isBlank(descr)){
            return "";
        }
        return this.descr.replaceAll("\"","'");
    }
}