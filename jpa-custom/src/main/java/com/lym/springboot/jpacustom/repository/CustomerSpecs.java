package com.lym.springboot.jpacustom.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 13:53
 */
public class CustomerSpecs {

    @SuppressWarnings("unchecked")
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {

        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    Object attrValue = getValue(example, attr);
                    if (attrValue != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(attrValue)) {
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attr.getName(), String.class)), pattern(attrValue.toString())));
                            }
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attr.getName(), attrValue.getClass())), attrValue));
                        }
                    }
                }
                return predicates.isEmpty() ? criteriaBuilder.conjunction() : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

            /**
             *  获取属性值
             * @param example
             * @param attr
             * @param <T>
             * @return
             */
            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            /**
             * 获取字段的属性
             * @param entity
             * @param fieldName
             * @param fieldClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

            /**
             * 增加 %前缀和%后缀
             * @param str
             * @return
             */
            private String pattern(String str) {
                return "%" + str + "%";
            }
        };
    }
}
