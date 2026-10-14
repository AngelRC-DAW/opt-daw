package com.actividad5.Actividad6.model;

public class Registro {
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasenia;

    public Registro() {
    }

    public Registro(String nombre, String apellidos, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
