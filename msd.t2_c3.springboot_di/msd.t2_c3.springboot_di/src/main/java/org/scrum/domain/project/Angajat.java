package org.scrum.domain.project;

public class Angajat implements Comparable<Angajat>{
    private Integer angajatId;
    private String numeAngajat;
    private String adresa;
    private String numarTelefon;
    private String email;
    private Pozitie pozitie;

    private enum Stare {
        ANGAJAT, CONCEDIAT
    }
    private Stare stare;

    public Pozitie getPozitie()
    {
        return pozitie;
    }
    public void setPozitie(Pozitie pozitie)
    {
        this.pozitie=pozitie;
    }



    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }
public String getAdresa()
{
    return adresa;
}
public void setAdresa(String adresa)
{
    this.adresa=adresa;
}
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getNumarTelefon()
    {
        return numarTelefon;
    }
    public void setNumarTelefon(String numarTelefon)
    {
        this.numarTelefon=numarTelefon;
    }
    public Integer getAngajatId() {
        return angajatId;
    }
    public void setAngajatId(Integer angajatId) {
        this.angajatId = angajatId;
    }
    public String getNumeAngajat() {
        return numeAngajat;
    }
    public void setNumeAngajatId(String numeAngajat) {
        this.numeAngajat = numeAngajat;
    }

    @Override
    public int compareTo(Angajat other) {
        if (this.equals(other))
            return 0;
        return this.getNumeAngajat().compareTo(other.getNumeAngajat());
    }
    public Angajat(Integer angajatId, String numeAngajat) {
        super();
        this.angajatId = angajatId;
        this.numeAngajat = numeAngajat;
    }
    public Angajat(Integer angajatId, String numeAngajat, String adresa, String numarTelefon, String email, Pozitie pozitie, Stare stare) {
        super();
        this.angajatId = angajatId;
        this.numeAngajat = numeAngajat;
        this.adresa=adresa;
        this.numarTelefon=numarTelefon;
        this.email=email;
        this.pozitie=pozitie;
        this.stare=stare;
    }
    public Angajat() {
        super();
    }
    public String toString() {
        return "\n\t\tAngajat  [id=" + angajatId + ", name=" + numeAngajat +"]";
    }
}


