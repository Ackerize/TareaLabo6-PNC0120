package com.uca.capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {

    @Id
    @Column(name = "c_contribuyente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoContribuyente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_importancia")
    private Importancia importancia;

    @Column(name = "s_nombre")
    @Size(min = 1, max = 30, message = "El campo de nombre debe de tener una longitud entre 1 y 30 caracteres")
    private String nombre;

    @Column(name = "s_apellido")
    @Size(min = 1, max = 30, message = "El campo de apellido debe de tener una longitud entre 1 y 30 caracteres")
    private String apellido;

    @Column(name = "s_nit")
    @Size(min = 1, max = 14, message = "El campo de NIT debe de tener una longitud entre 1 y 14 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "Solo se aceptan numeros")
    private String nit;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "f_fecha_ingreso")
    private Date fechaIngreso;


    public Contribuyente() {
    }


    public Importancia getImportancia() {
        return importancia;
    }

    public void setImportancia(Importancia importancia) {
        this.importancia = importancia;
    }

    public Integer getCodigoContribuyente() {
        return codigoContribuyente;
    }

    public void setCodigoContribuyente(Integer codigoContribuyente) {
        this.codigoContribuyente = codigoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFechaIngreso() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatter.format(fechaIngreso);
        return fecha;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
