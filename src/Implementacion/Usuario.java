/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

/**
 *
 * @author AndrésFelipe
 * 
 * La clase usuario se crea con el fin de utilizar el patron de diseño DAO
 */
public class Usuario {
    /**
     * Campos que representan un usuario, también deben encontrarse en la base
     * de datos
     */
    private String cedula;
    private String passwd;
    private String nombre;
    private String estado;
    private String rol;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String celular;
    private String fecha_incorporacion;
    private String salario;
    private String cuenta;

    /**
     * Constructor para crear un usuario con datos nulos
     */
    public Usuario() {
        this.cedula = null;
        this.passwd = null;
        this.nombre = null;
        this.estado = null;
        this.rol = null;
        this.fecha_nacimiento = null;
        this.direccion = null;
        this.telefono = null;
        this.celular = null;
        this.fecha_incorporacion = null;
        this.salario = null;
        this.cuenta = null;
    }
    /**
     * Constructor para crear un usuario dados los datos
     * @param cedula : cedula del usuario
     * @param passwd : password del usuario
     * @param nombre : nombre del usuario
     * @param estado : estado del usuario (Activo ó Inactivo)
     * @param rol : Rol del usuario (administrador, operario...)
     * @param fecha_nacimiento : fecha de nacimiento del usuario
     * @param direccion : direccion del usuario
     * @param telefono : telefono del usuario
     * @param celular : celular del usuario
     * @param fecha_incorporacion : fecha de incorporacion del usuario a la empresa
     * @param salario : salario asignado al usuario
     * @param cuenta : cuenta bancaria del usuario
     */
    public Usuario(String cedula, String passwd, String nombre, String estado, String rol, String fecha_nacimiento, String direccion, String telefono, String celular, String fecha_incorporacion, String salario, String cuenta) {
        this.cedula = cedula;
        this.passwd = passwd;
        this.nombre = nombre;
        this.estado = estado;
        this.rol = rol;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.fecha_incorporacion = fecha_incorporacion;
        this.salario = salario;
        this.cuenta = cuenta;
    }

    /**
     * Getters and Setters de los atributos de la clase
     * 
     */
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFecha_incorporacion() {
        return fecha_incorporacion;
    }

    public void setFecha_incorporacion(String fecha_incorporacion) {
        this.fecha_incorporacion = fecha_incorporacion;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
   
}
