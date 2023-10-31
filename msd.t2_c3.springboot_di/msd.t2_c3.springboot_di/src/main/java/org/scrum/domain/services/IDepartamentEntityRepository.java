package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Project;

import java.util.Collection;

public interface IDepartamentEntityRepository {

    public Integer getNextID() ;

    //
    public Departament getById(Integer id);
    public Departament get(Departament sample);
    public Collection<Departament> toCollection(); // getAll

    //
    public Departament add(Departament entity);
    public Collection<Departament> addAll(Collection<Departament> entities);
    public boolean remove(Departament entity);
    public boolean removeAll(Collection<Departament> entities);

    //
    public int size();
}
