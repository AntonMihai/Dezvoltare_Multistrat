package org.scrum.domain.services;

import jakarta.annotation.PostConstruct;
import org.scrum.domain.project.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("AngajatEntityFactoryBaseCDI")
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AngajatEntityFactoryImpl  implements IAngajatEntityFactory{
    private static Logger logger = Logger.getLogger(AngajatEntityFactoryImpl.class.getName());

    public AngajatEntityFactoryImpl() {
        logger.info(">>> BEAN: AngajatEntityFactoryImpl instantiated!");
    }
    @Autowired
    private IAngajatEntityRepository entityRepository;
    @Override
    public void setAngajatEntityRepository(IAngajatEntityRepository repository) {
        this.entityRepository = repository;
    }
    @Override
    public IAngajatEntityRepository getAngajatEntityRepository() {
        return entityRepository;
    }
    @Override
    public Angajat buildAngajat(String numeAngajat)
    {
        Integer nextID = this.entityRepository.getNextID();
    Angajat newAngajat= new Angajat(nextID,numeAngajat);
        logger.info("NEW angajat "+newAngajat.getAngajatId()+")"+newAngajat.getNumeAngajat());
        return newAngajat;
    }
    @PostConstruct
    private void initDomainServiceEntities() {
        logger.info(">> PostConstruct :: initDomainServiceEntities");
        entityRepository.add(buildAngajat("Covor Marcel:"));


        logger.info(">> EntityRepository angajat count :: " + entityRepository.size());
    }

}
