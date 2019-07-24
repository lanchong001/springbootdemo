package com.lym.spring.boot.jpa.sqlite.service.impl;

import com.lym.spring.boot.jpa.sqlite.domain.DatasourceLinkEntity;
import com.lym.spring.boot.jpa.sqlite.repository.DatasourceLinkRepository;
import com.lym.spring.boot.jpa.sqlite.service.DatasourceLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DatasourceLinkServiceImpl implements DatasourceLinkService {

    @Autowired
    private DatasourceLinkRepository datasourceLinkRepository;


    @Override
    public boolean edit(String id) {
        Optional<DatasourceLinkEntity> datasourceLinkEntity = datasourceLinkRepository.findById(id);
        if (datasourceLinkEntity != null && datasourceLinkEntity.get().getId().equals(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(DatasourceLinkEntity datasourceLinkEntity) {
        DatasourceLinkEntity save = datasourceLinkRepository.save(datasourceLinkEntity);
        if (save != null && !StringUtils.isEmpty(save.getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int remove = datasourceLinkRepository.remove(id);
        if (remove >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<DatasourceLinkEntity> getList(DatasourceLinkEntity datasourceLinkEntity, Integer page, Integer size) {
        return datasourceLinkRepository.findAll();
    }
}
