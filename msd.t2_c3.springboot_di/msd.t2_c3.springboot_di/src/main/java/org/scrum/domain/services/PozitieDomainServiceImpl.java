package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PozitieDomainServiceImpl implements IPozitieDomainService{
    @Autowired
    private IPozitieEntityRepository entityRepository;

    public void setPozitieEntityRepository(IPozitieEntityRepository repository) {
        this.entityRepository = repository;
    }
    public PozitieDomainServiceImpl() {
        super();
    }

    public PozitieDomainServiceImpl(IPozitieEntityRepository entityRepository) {
        super();
        this.entityRepository = entityRepository;
    }

}
