package com.lym.springboot.junit.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lbx.framework.common.enums.ResultEnum;
import com.lbx.framework.common.exception.WebApiException;
import com.lbx.framework.common.util.MD5Util;
import com.lym.springboot.junit.domain.WebApiBase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Web api assert.
 *
 * @Author: in liuyuanming
 * @Description: WebApi 参数验证
 * @Date:Created in 2019/5/7 21:44
 */
public class WebApiAssert {
    /**
     * 验证参数是否合法
     *
     * @param <T>    the type parameter
     * @param entity 参数实体对象
     */
    public static <T extends WebApiBase> void validation(T entity) {
        long timeout = Long.parseLong(getValue("webapi.timeout"));
        Class className = entity.getClass();
        Field[] fields = className.getDeclaredFields();
        WebApiBase baseVo = (WebApiBase) entity;
        long timeStamp = baseVo.getTimeStamp();
        long hadTimeout = System.currentTimeMillis() - (timeStamp > 9999999999L ? timeStamp : timeStamp * 1000);

//        //超时
//        if (hadTimeout > timeout) {
//            throw new WebApiException(ResultEnum.REQUEST_TIMEOUT.getCode(), ResultEnum.REQUEST_TIMEOUT.getMessage());
//        }

        String appId = baseVo.getAppId();
        String appKey = getAppKey(appId);


        String sign = baseVo.getSign();
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("app_id", appId);
        parameters.put("nonce_str", baseVo.getNonceStr());
        parameters.put("time_stamp", timeStamp);

        for (Field field : fields) {
            try {
                parameters.put(getFieldName(field), getFieldValue(field, entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //accsii升序排序
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            // 排除字段名为null，对应值为null或者空字符串
            if (null != v && null != k && !"".equals(v) && !"sign".equals(k) && !"app_key".equals((k))) {
                String value = null;
                try {
                    value = URLEncoder.encode(getCostomValue(v), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(k + "=" + value + "&");
            } else {
                continue;
            }
        }
        //最后拼接appKey
        sb.append("app_key=" + appKey);
        System.out.println(sb.toString());
        String theSign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        System.out.println(theSign);
        if (!theSign.equals(sign)) {
            throw new WebApiException(ResultEnum.AUTH_FAILURE.getCode(), ResultEnum.AUTH_FAILURE.getMessage());
        }
    }


    /**
     * 判断是否是系统类型
     *
     * @param clz the clz
     * @return the boolean
     */
    public static boolean isJavaClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }

    /**
     * 判断对象是否是集合类型
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isIterable(Object object) {
        if (object instanceof Iterable) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否是Map类型
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isMap(Object object) {
        if (object instanceof Map) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否是Date类型
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isDate(Object object) {
        if (object instanceof Date) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否是数组
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isArray(Object object) {
        if (object.getClass().isArray()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取对应的值,自定义类型，集合类型，Map类型,数组,则获取对象Json格式的字符串
     *
     * @param object the object
     * @return the value
     */
    public static String getCostomValue(Object object) {
        if (isIterable(object) || isMap(object) || isArray(object)) {
            return JSONObject.toJSONString(object);
        } else if (!isJavaClass(object.getClass())) {
            return JSONObject.toJSONString(object);
        } else if (isDate(object)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(object);
        } else {
            return object.toString();
        }
    }

    /**
     * 获取字段的值
     *
     * @param field the field
     * @return field name
     */
    public static String getFieldName(Field field) {
        String fieldName = "";
        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof JsonProperty) {
                JsonProperty jsonProperty = (JsonProperty) annotation;
                fieldName = jsonProperty.value();
            }
        }
        if (StringUtils.isEmpty(fieldName)) {
            fieldName = field.getName();
        }
        return fieldName;
    }

    /**
     * Gets field value.
     *
     * @param <T>    the type parameter
     * @param field  the field
     * @param entity the entity
     * @return the field value
     * @throws IllegalAccessException the illegal access exception
     */
    public static <T extends WebApiBase> Object getFieldValue(Field field, T entity) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(entity);
    }


    /**
     * Get Bean Value
     *
     * @param key the key
     * @return value
     */
    public static String getValue(String key) {
        try {
            Resource resource = new ClassPathResource("application.yml");
            FileInputStream in = new FileInputStream(resource.getFile());
            Properties pro = new Properties();
            pro.load(in);
            Iterator<String> it = pro.stringPropertyNames().iterator();
            while (it.hasNext()) {
                if (it.next().equals(key)) {
                    return pro.getProperty(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认5秒
        return "5000";
    }


    /**
     * Get AppKey
     *
     * @param appId
     * @return
     */
    private static String getAppKey(String appId) {
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, Object> map = new HashMap<>();
//        map.put("appId", appId);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);
//        JSONObject obj = restTemplate.postForEntity("http://10.249.0.121:30015/auditLog/findByAppId", request, JSONObject.class).getBody();
//        obj = obj.getJSONObject("data");
//        String appKey = obj.getString("apiKey");
//        return appKey;
        return "6301CA9D49678A0AA32E6C4482DAEB64";
    }


}
