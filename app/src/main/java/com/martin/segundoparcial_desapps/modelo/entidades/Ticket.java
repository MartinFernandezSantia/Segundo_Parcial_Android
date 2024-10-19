package com.martin.segundoparcial_desapps.modelo.entidades;

import java.util.Objects;

public class Ticket {
    private Integer id;
    private String titulo;
    private String descripcion;
    private Usuario usuario;

    public Ticket() {}

    public Ticket(Integer id, String titulo, String descripcion, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Ticket(String titulo, String descripcion, Usuario usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getId(), ticket.getId()) && Objects.equals(getTitulo(), ticket.getTitulo()) && Objects.equals(getDescripcion(), ticket.getDescripcion()) && Objects.equals(getUsuario(), ticket.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getDescripcion(), getUsuario());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
