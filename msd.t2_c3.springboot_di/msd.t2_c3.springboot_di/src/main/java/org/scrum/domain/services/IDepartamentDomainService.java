package org.scrum.domain.services;

import org.scrum.domain.project.Departament;
import org.scrum.domain.project.Feature;
import org.scrum.domain.project.Pozitie;
import org.scrum.domain.project.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDepartamentDomainService {
    public List<Pozitie> getPozitiiDepartament(Departament departament);
    public Integer getPozitiiDepartamentCount(Departament departament);

    public List<Pozitie> getPozitiiDepartament(Integer departamentId);
    public Integer getPozitiiDepartamentCount(Integer departamentId);

    public Pozitie getPozitieDepartament(Departament departament, String pName);



    public void setDepartamentEntityRepository(IDepartamentEntityRepository repository);


}
