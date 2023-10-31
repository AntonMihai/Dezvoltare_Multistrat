package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.springframework.stereotype.Service;

@Service
public interface IPozitieDomainService {

    public void setPozitieEntityRepository(IPozitieEntityRepository repository);


}
