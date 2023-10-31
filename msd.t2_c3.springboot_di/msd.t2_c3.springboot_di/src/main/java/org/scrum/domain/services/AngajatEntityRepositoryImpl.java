package org.scrum.domain.services;

import org.scrum.domain.project.Angajat;
import org.scrum.domain.project.Departament;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AngajatEntityRepositoryImpl implements IAngajatEntityRepository{
    private static Logger logger = Logger.getLogger(AngajatEntityRepositoryImpl.class.getName());
    public AngajatEntityRepositoryImpl() {
        logger.info(">>> BEAN: AngajatEntityRepositoryImpl instantiated!");
    }

    private Map<Integer, Angajat> entities = new HashMap<>();

    private Integer nextID = 0;

    @Override
    public Integer getNextID() {
        nextID++;
        return nextID;
    }
    @Override
    public Angajat getById(Integer id) {
        return entities.get(id);
    }

    @Override
    public Angajat get(Angajat sample) {
        return getById(sample.getAngajatId());
    }

    @Override
    public Collection<Angajat> toCollection() {
        List<Angajat> angajatList = new ArrayList<>();
        angajatList.addAll(this.entities.values());
        return angajatList;
    }

    @Override
    public Angajat add(Angajat entity) {
        if (entity.getAngajatId() == null) {
            nextID++;
            entity.setAngajatId(nextID);
        }
        entities.put(entity.getAngajatId(), entity);
        return entity;
    }

    @Override
    public Collection<Angajat> addAll(Collection<Angajat> entities) {
        for(Angajat entity: entities)
            this.add(entity);
        return entities;
    }

    @Override
    public boolean remove(Angajat entity) {
        if (this.entities.containsValue(entity)) {
            this.entities.remove(entity.getAngajatId());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<Angajat> entities) {
        Boolean flag =  true;
        for(Angajat entity: entities) {
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
