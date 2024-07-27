package com.agencia.personaskill.domain.entity;

public class AsignarSkill {
    private int id;
    private String registrationDate;
    private int idPerson;
    private int idSkill;
    
    public AsignarSkill() {
    }

    public AsignarSkill(int id, String registrationDate, int idPerson, int idSkill) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.idPerson = idPerson;
        this.idSkill = idSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

}
