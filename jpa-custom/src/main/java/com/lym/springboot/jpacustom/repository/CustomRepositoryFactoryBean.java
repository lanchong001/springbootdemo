package com.lym.springboot.jpacustom.repository;

import com.lym.springboot.jpacustom.repository.impl.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @Author: in liuyuanming
 * @Description:
 * @Date:Created in  2019/5/27 15:15
 */
public class CustomRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID> {

    public CustomRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomeRepositoryFactory(entityManager);
    }

    private static class CustomeRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

        private final EntityManager em;

        public CustomeRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.em = entityManager;
        }

        @Override
        @SuppressWarnings({"unchecked"})
        protected JpaRepositoryImplementation<T, ID> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
            return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}
