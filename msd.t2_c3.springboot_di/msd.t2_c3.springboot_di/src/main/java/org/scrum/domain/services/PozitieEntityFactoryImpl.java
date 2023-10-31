package org.scrum.domain.services;

import jakarta.annotation.PostConstruct;

import org.scrum.domain.project.Pozitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

@Component("PozitieEntityFactoryBaseCDI")
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PozitieEntityFactoryImpl implements IPozitieEntityFactory {

    private static Logger logger = Logger.getLogger(DepartamentEntityFactoryImpl.class.getName());

    public PozitieEntityFactoryImpl() {
        logger.info(">>> BEAN: PozitieEntityFactoryImpl instantiated!");
    }
    @Autowired
    private IPozitieEntityRepository entityRepository;

    @Override
    public void setPozitieEntityRepository(IPozitieEntityRepository repository) {
        this.entityRepository = repository;
    }

    @Override
    public IPozitieEntityRepository getPozitieEntityRepository() {
        return entityRepository;
    }

    public PozitieEntityFactoryImpl(IPozitieEntityRepository entityRepository) {
        super();
        this.entityRepository = entityRepository;
    }
@Override
    public Pozitie buildPozitie(String name) {
        Integer nextID = this.entityRepository.getNextID();

       Pozitie newPozitie = new Pozitie(nextID, name);

    logger.info("NEW pozitie "+newPozitie.getName());
    return newPozitie;

    }
    @PostConstruct
    private void initDomainServiceEntities() {
        logger.info(">> PostConstruct :: initDomainServiceEntities");
        entityRepository.add(buildPozitie("Asistent medical"));


        logger.info(">> EntityRepository pozitie count :: " + entityRepository.size());
    }
}
