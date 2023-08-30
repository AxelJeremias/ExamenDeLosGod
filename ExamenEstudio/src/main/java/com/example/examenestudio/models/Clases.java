package com.example.examenestudio.models;

public class Clases {

    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Long instructor;

    public Clases() {
    }

    public Clases(Long id, String nombreC, String descripcion, String estado, Long instructor) {
        this.id = id;
        this.nombre = nombreC;
        this.descripcion = descripcion;
        this.estado = estado;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreC) {
        this.nombre = nombreC;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getInstructor() {
        return instructor;
    }

    public void setInstructor(Long instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "Clases{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
