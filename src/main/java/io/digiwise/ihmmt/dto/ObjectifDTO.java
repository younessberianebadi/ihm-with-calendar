package io.digiwise.ihmmt.dto;

import io.digiwise.ihmmt.model.Objectif;

import java.util.List;

public class ObjectifDTO {
    private List<Objectif> objectifs;

    public ObjectifDTO() {
    }

    public ObjectifDTO(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    public void addObjectif(Objectif objectif){
        this.objectifs.add(objectif);
    }

    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }
}
