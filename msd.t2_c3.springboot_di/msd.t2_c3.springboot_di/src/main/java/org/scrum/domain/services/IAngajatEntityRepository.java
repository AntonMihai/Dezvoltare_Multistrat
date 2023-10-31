package org.scrum.domain.services;

import org.scrum.domain.project.Angajat;
import org.scrum.domain.project.Departament;

import java.util.Collection;

public interface IAngajatEntityRepository {
    public Integer getNextID() ;

    //
    public Angajat getById(Integer id);
    public Angajat get(Angajat sample);
    public Collection<Angajat> toCollection(); // getAll

    //
    public Angajat add(Angajat entity);
    public Collection<Angajat> addAll(Collection<Angajat> entities);
    public boolean remove(Angajat entity);
    public boolean removeAll(Collection<Angajat> entities);

    //
    public int size();
}
