package org.scrum.domain.project;

import java.util.ArrayList;
import java.util.List;

public class Departament implements Comparable<Departament> {


    private Integer departamentId;
    private String name;
    private String departamentDescription;
    private List<Pozitie> pozitii = new ArrayList<>();




    public List<Pozitie> getPozitii() {
        return pozitii;
    }
    public void setPozitii(List<Pozitie> pozitii) {
        this.pozitii = pozitii;
    }

    public Integer getDepartamentId() {
        return departamentId;
    }
    public void setDepartamentId(Integer departamentId) {
        this.departamentId = departamentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartamentDescription() {
        return departamentDescription;
    }
    public void setDepartamentDescription(String departamentDescription) {
        this.departamentDescription = departamentDescription;
    }

    public Departament() {
        super();
    }

    public Departament(Integer departamentId, String name, String departamentDescription) {
        super();
        this.departamentId = departamentId;
        this.name = name;
        this.departamentDescription = departamentDescription;
    }
    public Departament(Integer departamentId, String name) {
        super();
        this.departamentId = departamentId;
        this.name = name;
    }
    @Override
    public int compareTo(Departament other) {
        if (this.equals(other))
            return 0;
        return this.getName().compareTo(other.getName());
    }
    public String toString() {
        return "\n\t\tDepartament [id=" + departamentId + ", name=" + name +"]";
    }
}
