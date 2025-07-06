package ru.lkodos.entity;

import java.util.Objects;

public class Fish {

    Integer id;
    String fishName;

    public Fish(Integer id, String fishName) {
        this.id = id;
        this.fishName = fishName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return Objects.equals(id, fish.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Fish{" +
               "id=" + id +
               ", fishName='" + fishName + '\'' +
               '}';
    }
}
