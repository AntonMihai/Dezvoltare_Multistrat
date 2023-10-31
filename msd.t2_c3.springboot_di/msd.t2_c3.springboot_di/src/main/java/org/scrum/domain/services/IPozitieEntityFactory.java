package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Pozitie;

public interface IPozitieEntityFactory {
    public void setPozitieEntityRepository(IPozitieEntityRepository repository);

    public Pozitie buildPozitie(String name);
    public IPozitieEntityRepository getPozitieEntityRepository();
}
