package com.example.examenestudio.models;

public class Temarios {
    private Long id;
    private String descripcion;
    private Long clases;
    Temarios (){
    }

    public Temarios(Long id, String descripcionT, Long clases) {
        this.id = id;
        this.descripcion = descripcionT;
        this.clases = clases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcionT) {
        this.descripcion = descripcionT;
    }

    public Long getClases() {
        return clases;
    }

    public void setClases(Long clases) {
        this.clases = clases;
    }

    @Override
    public String toString() {
        return "Temarios{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", clases=" + clases +
                '}';
    }
}
