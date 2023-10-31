package org.scrum.domain.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestJupiterPozitieDomainServiceDefSDI {
    private static Logger logger = Logger.getLogger(TestJupiterPozitieDomainServiceDefSDI.class.getName());
    @Autowired
    private IPozitieDomainService service;

    @Autowired
    private IPozitieEntityRepository repository;

    @Autowired // @Qualifier("projectFactory")
    private IPozitieEntityFactory factory;
    @Test
    public void test() {
        logger.info("Repository implementation object:: " + repository);
        logger.info("Repository implementation class:: " + repository.getClass().getName());
        //
        logger.info("Factory implementation object:: " + factory);
        logger.info("Factory implementation class:: " + factory.getClass().getName());
        // CDI -> Service -> Factory @PostConstruct :: initDomainServiceEntities -- Repository
        logger.info("Service implementation object:: " + service);
        logger.info("Service implementation class:: " + service.getClass().getName());
        //

    }

    @Autowired @Qualifier("PozitieEntityFactoryBaseCDI")
    private IPozitieEntityFactory pozitieFactory;

    @Test
    public void testPozitieEntityFactory() {
        // CDI -> AppContextConfig -> @Produces IProjectEntityFactory :: initDomainServiceEntities -- Repository
        Integer pozitieCounts = pozitieFactory.getPozitieEntityRepository().size();
        assertTrue(pozitieCounts > 0, "Pozitie not counting...");
        logger.info("Pozitie count:: " + pozitieCounts);
        logger.info("Poztitie " + pozitieFactory.getPozitieEntityRepository().getById(1));
    }

}
