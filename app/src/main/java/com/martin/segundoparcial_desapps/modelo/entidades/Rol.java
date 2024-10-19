package com.martin.segundoparcial_desapps.modelo.entidades;

import java.util.Objects;

public class Rol {
    private Integer id;
    private String rol;

    public Rol() {}

    public Rol(Integer id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol1 = (Rol) o;
        return Objects.equals(getId(), rol1.getId()) && Objects.equals(getRol(), rol1.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRol());
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }
}
