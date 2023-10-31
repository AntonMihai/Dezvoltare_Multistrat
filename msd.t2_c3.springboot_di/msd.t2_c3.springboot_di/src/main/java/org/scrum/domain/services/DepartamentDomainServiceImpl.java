package org.scrum.domain.services;

import org.scrum.domain.project.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartamentDomainServiceImpl implements IDepartamentDomainService{
    @Autowired
    private IDepartamentEntityRepository entityRepository;

    public void setDepartamentEntityRepository(IDepartamentEntityRepository repository) {
        this.entityRepository = repository;
    }

    public DepartamentDomainServiceImpl() {
        super();
    }

    //	@Autowired
    public DepartamentDomainServiceImpl(IDepartamentEntityRepository entityRepository) {
        super();
        this.entityRepository = entityRepository;
    }

@Override
    public List<Pozitie> getPozitiiDepartament(Departament departament)
    {
        List<Pozitie> pozitiiDepartament = new ArrayList<>();
        for (Pozitie p : departament.getPozitii())
            pozitiiDepartament.add(p);
        return pozitiiDepartament;
    }
    @Override
    public Integer getPozitiiDepartamentCount(Departament departament)
    {
        List<Pozitie> pozitiiDepartament = getPozitiiDepartament(departament);
        return pozitiiDepartament.size();

    }
@Override
    public List<Pozitie> getPozitiiDepartament(Integer departamentId){
        Departament departament = entityRepository.getById(departamentId);
        return getPozitiiDepartament(departament);

    }

@Override
    public Integer getPozitiiDepartamentCount(Integer departamentId)
    {
        Departament departament = entityRepository.getById(departamentId);
        return getPozitiiDepartamentCount(departament);
    }
@Override
    public Pozitie getPozitieDepartament(Departament departament, String pName)
    {
        List<Pozitie> pozitiiDepartament= getPozitiiDepartament(departament);
        List<Pozitie> pozitii = pozitiiDepartament.stream().filter(f -> f.getName().equals(pName)).collect(Collectors.toList());
        if (pozitii.size() > 0)
            return pozitii.get(0);

        return null;
    }



}
