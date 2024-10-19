package com.martin.segundoparcial_desapps.modelo.entidades;

import java.util.Objects;

public class Usuario {
    private Integer id;
    private int nroId;
    private String password;
    private Rol rol;

    public Usuario() {}

    public Usuario(Integer id, int nroId, String password, Rol rol) {
        this.id = id;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(int nroId, String password, Rol rol) {
        this.password = password;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNroId() {
        return nroId;
    }

    public void setNroId(int nroId) {
        this.nroId = nroId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getNroId() == usuario.getNroId() && Objects.equals(getId(), usuario.getId()) && Objects.equals(getPassword(), usuario.getPassword()) && Objects.equals(getRol(), usuario.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNroId(), getPassword(), getRol());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nroId=" + nroId +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
