package org.scrum.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AngajatDomainServiceImpl implements IAngajatDomainService{

    @Autowired
    private IAngajatEntityRepository entityRepository;
    public void setAngajatEntityRepository(IAngajatEntityRepository repository) {
        this.entityRepository = repository;
    }
    public AngajatDomainServiceImpl() {
        super();
    }
    public AngajatDomainServiceImpl(IAngajatEntityRepository entityRepository) {
        super();
        this.entityRepository = entityRepository;
    }
}
