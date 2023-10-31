package org.scrum.domain.services;
import jakarta.annotation.PostConstruct;
import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Pozitie;
import org.scrum.domain.project.Project;
import org.scrum.domain.project.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
@Component("DepartamentEntityFactoryBaseCDI")
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DepartamentEntityFactoryImpl implements IDepartamentEntityFactory {

    private static Logger logger = Logger.getLogger(DepartamentEntityFactoryImpl.class.getName());

    public DepartamentEntityFactoryImpl() {
        logger.info(">>> BEAN: DepartamentEntityFactoryImpl instantiated!");
    }
    @Autowired
    private IDepartamentEntityRepository entityRepository;

    @Override
    public void setDepartamentEntityRepository(IDepartamentEntityRepository repository) {
        this.entityRepository = repository;
    }

    @Override
    public IDepartamentEntityRepository getDepartamemtEntityRepository() {
        return entityRepository;
    }

    public DepartamentEntityFactoryImpl(IDepartamentEntityRepository entityRepository) {
        super();
        this.entityRepository = entityRepository;
    }

    public Departament buildDepartament(String name) {
        Integer nextID = this.entityRepository.getNextID();


        Departament newDepartament = new Departament(nextID, name);
        Pozitie pozitie1 = new Pozitie(1, "Asistent contabil");
        Pozitie pozitie2 = new Pozitie(2, "Manager contabil");
        List<Pozitie> pozitii = new ArrayList<>();
        pozitii.add(pozitie1);
        pozitii.add(pozitie2);
        newDepartament.setPozitii(pozitii);

        logger.info("NEW departament "+newDepartament.getName()+"[ "+newDepartament.getPozitii().get(0)+", "+newDepartament.getPozitii().get(1)+"]");
        //logger.info("NEW departament "+newDepartament.getName());
        return newDepartament;
        //aiici pozitie


    }
    @PostConstruct
    private void initDomainServiceEntities() {
        logger.info(">> PostConstruct :: initDomainServiceEntities");
        entityRepository.add(buildDepartament("Contabilitate:"));


        logger.info(">> EntityRepository departament count :: " + entityRepository.size());
    }
}
