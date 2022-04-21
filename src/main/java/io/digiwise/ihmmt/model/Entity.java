package io.digiwise.ihmmt.model;

public class Entity {
    private long id;
    private String level;
    private String name;
    private long idParent;
    private long idDirector;

    public Entity(){

    }

    public Entity(long id, String level, String name, long idParent, long idDirector) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.idParent = idParent;
        this.idDirector = idDirector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdParent() {
        return idParent;
    }

    public void setIdParent(long idParent) {
        this.idParent = idParent;
    }

    public long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(long idDirector) {
        this.idDirector = idDirector;
    }
}
