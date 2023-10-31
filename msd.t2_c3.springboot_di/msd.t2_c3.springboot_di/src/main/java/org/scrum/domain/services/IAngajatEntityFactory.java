package org.scrum.domain.services;

import org.scrum.domain.project.Angajat;
import org.scrum.domain.project.Departament;

public interface IAngajatEntityFactory {

    public void setAngajatEntityRepository(IAngajatEntityRepository repository);

    public Angajat buildAngajat(String numeAngajat);
    public IAngajatEntityRepository getAngajatEntityRepository();
}
