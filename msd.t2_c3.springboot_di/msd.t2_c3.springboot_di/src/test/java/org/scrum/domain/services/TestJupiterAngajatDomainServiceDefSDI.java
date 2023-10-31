package org.scrum.domain.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestJupiterAngajatDomainServiceDefSDI {
    private static Logger logger = Logger.getLogger(TestJupiterAngajatDomainServiceDefSDI.class.getName());
    @Autowired
    private IAngajatDomainService service;

    @Autowired
    private IAngajatEntityRepository repository;

    @Autowired // @Qualifier("projectFactory")
    private IAngajatEntityFactory factory;
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
    @Autowired @Qualifier("AngajatEntityFactoryBaseCDI")
    private IAngajatEntityFactory angajatFactory;

    @Test
    public void testDepartamentEntityFactory() {
        // CDI -> AppContextConfig -> @Produces IProjectEntityFactory :: initDomainServiceEntities -- Repository
        Integer angajatCounts = angajatFactory.getAngajatEntityRepository().size();
        assertTrue(angajatCounts > 0, "Angajat not counting...");
        logger.info(" Angajat count:: " + angajatCounts);
        logger.info("Angajat  " + angajatFactory.getAngajatEntityRepository().getById(1));


    }
}
