package org.scrum.domain.services;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;
@SpringBootTest
public class TestJupiterDepartamentDomainServiceDefSDI {
    private static Logger logger = Logger.getLogger(TestJupiterDepartamentDomainServiceDefSDI.class.getName());
    @Autowired
    private IDepartamentDomainService service;

    @Autowired
    private IDepartamentEntityRepository repository;

    @Autowired // @Qualifier("projectFactory")
    private IDepartamentEntityFactory factory;
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
    @Autowired @Qualifier("DepartamentEntityFactoryBaseCDI")
    private IDepartamentEntityFactory departamentFactory;

    @Test
    public void testDepartamentEntityFactory() {
        // CDI -> AppContextConfig -> @Produces IProjectEntityFactory :: initDomainServiceEntities -- Repository
        Integer departamentCounts = departamentFactory.getDepartamemtEntityRepository().size();
        assertTrue(departamentCounts > 0, "Departaments not counting...");
        logger.info("Departament count:: " + departamentCounts);
        logger.info("Departament " + departamentFactory.getDepartamemtEntityRepository().getById(1));

    }
}
