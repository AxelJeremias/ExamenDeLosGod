package com.example.examenestudio.models;

public class Users {

    private Long id;
    private String nombre;

    private String apellidoP;
    private String apelldioM;
    private String correo;
    private String contra;
    private String curp;
    private String fecha;
    private String estado;
    private String rol;


    public Users (){

    }

    public Users(Long id, String nombre, String apellidoP, String apelldioM, String correo, String contra, String curp, String fecha, String estado, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apelldioM = apelldioM;
        this.correo = correo;
        this.contra = contra;
        this.curp = curp;
        this.fecha = fecha;
        this.estado = estado;
        this.rol = rol;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApelldioM() {
        return apelldioM;
    }

    public void setApelldioM(String apelldioM) {
        this.apelldioM = apelldioM;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apelldioM='" + apelldioM + '\'' +
                ", correo='" + correo + '\'' +
                ", contra='" + contra + '\'' +
                ", curp='" + curp + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
