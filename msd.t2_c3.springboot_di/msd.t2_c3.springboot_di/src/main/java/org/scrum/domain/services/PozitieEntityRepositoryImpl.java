package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Pozitie;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
@Scope("singleton")
public class PozitieEntityRepositoryImpl implements IPozitieEntityRepository{
    private static Logger logger = Logger.getLogger(PozitieEntityRepositoryImpl.class.getName());
    public PozitieEntityRepositoryImpl() {
        logger.info(">>> BEAN: PozitieEntityRepositoryImpl instantiated!");
    }

    private Map<Integer, Pozitie> entities = new HashMap<>();

    private Integer nextID = 0;

    @Override
    public Integer getNextID() {
        nextID++;
        return nextID;
    }
    @Override
    public Pozitie getById(Integer id)
    {
        return entities.get(id);
    }
    public Pozitie get(Pozitie sample)
    {
        return getById(sample.getPozitieId());
    }
    public Collection<Pozitie> toCollection() // getAll
    {
        List<Pozitie> pozitieList = new ArrayList<>();
        pozitieList.addAll(this.entities.values());
        return pozitieList;
    }

    @Override
    public Pozitie add(Pozitie entity){
        if (entity.getPozitieId() == null) {
            nextID++;
            entity.setPozitieId(nextID);
        }
        entities.put(entity.getPozitieId(), entity);
        return entity;
    }
    public Collection<Pozitie> addAll(Collection<Pozitie> entities)
    {
        for(Pozitie entity: entities)
            this.add(entity);
        return entities;
    }
    public boolean remove(Pozitie entity){
        if (this.entities.containsValue(entity)) {
            this.entities.remove(entity.getPozitieId());
            return true;
        }
        return false;
    }
    public boolean removeAll(Collection<Pozitie> entities) {
        Boolean flag = true;
        for (Pozitie entity : entities) {
            if (!this.remove(entity))
                flag = false;
        }
        return flag;
    }
@Override
    public int size() {
        return this.entities.values().size();
    }


}
