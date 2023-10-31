package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Project;

import java.util.Date;

public interface IDepartamentEntityFactory {
    // Dependencies to get IDs
    public void setDepartamentEntityRepository(IDepartamentEntityRepository repository);

    public Departament buildDepartament(String name);
    public IDepartamentEntityRepository getDepartamemtEntityRepository();

}
