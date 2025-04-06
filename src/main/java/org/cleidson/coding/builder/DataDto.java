package org.cleidson.coding.builder;

import java.util.Objects;

public class DataDto {

    private Long id;
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDto dataDto = (DataDto) o;
        return id.equals(dataDto.id) && value.equals(dataDto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
