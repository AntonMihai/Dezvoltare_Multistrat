package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Pozitie;

import java.util.Collection;

public interface IPozitieEntityRepository {
    public Integer getNextID() ;

    //
    public Pozitie getById(Integer id);
    public Pozitie get(Pozitie sample);
    public Collection<Pozitie> toCollection(); // getAll

    //
    public Pozitie add(Pozitie entity);
    public Collection<Pozitie> addAll(Collection<Pozitie> entities);
    public boolean remove(Pozitie entity);
    public boolean removeAll(Collection<Pozitie> entities);
    public int size();
}
