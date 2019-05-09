package com.lym.springboot.reflection.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lym.springboot.reflection.domain.BaseVo;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author: in liuyuanming
 * @Description: WebApi 参数验证
 * @Date:Created in  2019/5/7 21:44
 */
public class WebApiAssert {

    /**
     * 验证参数是否合法
     *
     * @param entity 参数实体对象
     * @param <T>
     */
    static public <T extends BaseVo> void validation(T entity) throws IllegalAccessException {
        Class className = entity.getClass();
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("变量为：" + getFieldName(field));
            System.out.println("变量为：" + getFieldValue(field, entity));
        }
        BaseVo baseVo = (BaseVo) entity;
        System.out.println("变量为： app_id");
        System.out.println("变量值为： " + baseVo.getAppId());
        System.out.println("变量为： nonce_str");
        System.out.println("变量值为： " + baseVo.getNonceStr());
        System.out.println("变量为： sign");
        System.out.println("变量值为： " + baseVo.getSign());
        System.out.println("变量为： time_stamp");
        System.out.println("变量值为： " + baseVo.getTimeStamp());
    }

    static public String getFieldName(Field field) {
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

    static public <T extends BaseVo> Object getFieldValue(Field field, T entity) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(entity);
    }
}
