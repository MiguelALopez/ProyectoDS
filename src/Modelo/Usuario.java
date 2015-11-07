/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author AndrésFelipe
 * 
 * La clase usuario se crea con el fin de utilizar el patron de diseño DAO
 */
public class Usuario 
{
    /**
     * Campos que representan un usuario, también deben encontrarse en la base
     * de datos
     */
    private String cedula;
    private String passwd;
    private String nombre;
    private String estado;
    private String rol;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String celular;
    private String fechaIncorporacion;
    private String salario;
    private String cuenta;
    private String numeroSede;

    /**
     * Constructor para crear un usuario con datos nulos
     */
    public Usuario() 
    {
        this.cedula = null;
        this.passwd = null;
        this.nombre = null;
        this.estado = null;
        this.rol = null;
        this.fechaNacimiento = null;
        this.direccion = null;
        this.telefono = null;
        this.celular = null;
        this.fechaIncorporacion = null;
        this.salario = null;
        this.cuenta = null;
        this.numeroSede = null;
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
     * @param numeroSede
     */
    public Usuario(String cedula, String passwd, String nombre, String rol, String estado, String fecha_nacimiento, String direccion, String telefono, String celular, String fecha_incorporacion, String salario, String cuenta, String numeroSede)
    {
        this.cedula = cedula;
        this.passwd = passwd;
        this.nombre = nombre;
        this.estado = estado;
        this.rol = rol;
        
        if (fecha_nacimiento!=null){
            this.fechaNacimiento = fecha_nacimiento;
        }
        else{
            this.fechaNacimiento  = "";
        }
        if (direccion != null){
            this.direccion = direccion;
        }
        else{
            this.direccion = "";
        }
        
        if (telefono != null){
            this.telefono = telefono;
        }
        else{
            this.telefono = "";
        }
        
        if (celular != null){
            this.celular = celular;
        }
        else{
            this.celular = "";
        }
        
        if (fecha_incorporacion != null){
            this.fechaIncorporacion = fecha_incorporacion;
        }
        else{
            this.fechaIncorporacion = "";
        }
        if(salario != null){
            this.salario = salario;
        }
        else{
            this.salario = "";
        }
        if(cuenta != null){
            this.cuenta = cuenta;
        }
        else{
            this.cuenta = "";
        }
        if(numeroSede!=null){
            this.numeroSede = numeroSede;
        }
        else{
            this.numeroSede = "";
        }
        
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFecha_incorporacion(String fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
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

    public String getNumeroSede() {
        return numeroSede;
    }

    public void setNumeroSede(String numeroSede) {
        this.numeroSede = numeroSede;
    }    
}
