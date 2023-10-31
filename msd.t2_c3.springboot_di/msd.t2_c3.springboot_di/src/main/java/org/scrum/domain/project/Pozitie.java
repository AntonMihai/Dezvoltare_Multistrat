package org.scrum.domain.project;

public class Pozitie implements Comparable<Pozitie> {
    private Integer pozitieId;
    private String name;
    private String pozitieDescription;
    private Departament departament;


public Departament getDepartament(){return this.departament;}

public void setDepartament(Departament departament)
{
    this.departament=departament;
}
    public Integer getPozitieId() {
        return pozitieId;
    }
    public void setPozitieId(Integer pozitieId) {
        this.pozitieId = pozitieId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPozitieDescription() {
        return pozitieDescription;
    }
    public void setPozitieDescription(String pozitieDescription) {
        this.pozitieDescription = pozitieDescription;
    }

    public Pozitie() {
        super();
    }

    public Pozitie(Integer pozitieId, String name, String pozitieDescription) {
        super();
        this.pozitieId = pozitieId;
        this.name = name;
        this.pozitieDescription = pozitieDescription;
    }
    public Pozitie(Integer pozitieId, String name) {
        super();
        this.pozitieId = pozitieId;
        this.name = name;
    }
    @Override
    public int compareTo(Pozitie other) {
        if (this.equals(other))
            return 0;
        return this.getName().compareTo(other.getName());
    }
    public String toString() {
        return "\n\t\tPozitie [id=" + pozitieId + ", name=" + name +"]";
    }
}
