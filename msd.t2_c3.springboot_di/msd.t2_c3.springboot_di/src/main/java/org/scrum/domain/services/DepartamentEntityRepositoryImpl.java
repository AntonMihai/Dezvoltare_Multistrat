package org.scrum.domain.services;
import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Project;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;
@Component
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public class DepartamentEntityRepositoryImpl implements IDepartamentEntityRepository {
    private static Logger logger = Logger.getLogger(DepartamentEntityRepositoryImpl.class.getName());
    public DepartamentEntityRepositoryImpl() {
        logger.info(">>> BEAN: DepartanentEntityRepositoryImpl instantiated!");
    }

    private Map<Integer, Departament> entities = new HashMap<>();

    private Integer nextID = 0;

    @Override
    public Integer getNextID() {
        nextID++;
        return nextID;
    }

    @Override
    public Departament getById(Integer id) {
        return entities.get(id);
    }

    @Override
    public Departament get(Departament sample) {
        return getById(sample.getDepartamentId());
    }

    @Override
    public Collection<Departament> toCollection() {
        List<Departament> departamentList = new ArrayList<>();
        departamentList.addAll(this.entities.values());
        return departamentList;
    }

    @Override
    public Departament add(Departament entity) {
        if (entity.getDepartamentId() == null) {
            nextID++;
            entity.setDepartamentId(nextID);
        }
        entities.put(entity.getDepartamentId(), entity);
        return entity;
    }

    @Override
    public Collection<Departament> addAll(Collection<Departament> entities) {
        for(Departament entity: entities)
            this.add(entity);
        return entities;
    }

    @Override
    public boolean remove(Departament entity) {
        if (this.entities.containsValue(entity)) {
            this.entities.remove(entity.getDepartamentId());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<Departament> entities) {
        Boolean flag =  true;
        for(Departament entity: entities) {
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
