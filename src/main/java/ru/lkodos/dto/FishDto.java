package ru.lkodos.dto;

import java.util.Objects;

public class FishDto {

    private final String fishName;

    public FishDto(String fishName) {
        this.fishName = fishName;
    }

    public String getFishName() {
        return fishName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FishDto fishDto = (FishDto) o;
        return Objects.equals(fishName, fishDto.fishName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fishName);
    }

    @Override
    public String toString() {
        return "FishDto{" +
               "fishName='" + fishName + '\'' +
               '}';
    }
}
