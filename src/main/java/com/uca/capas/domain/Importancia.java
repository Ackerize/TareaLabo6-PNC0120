package com.uca.capas.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name="importancia")
public class Importancia {

    @Id
    @Column(name = "c_importancia")
    private Integer codigoImportancia;

    @Column(name = "s_importancia")
    private String nombre;

    @OneToMany(mappedBy = "importancia", fetch = FetchType.EAGER)
    private List<Contribuyente> contribuyentes;

    public Importancia() {
    }

    public Integer getCodigoImportancia() {
        return codigoImportancia;
    }

    public void setCodigoImportancia(Integer codigoImportancia) {
        this.codigoImportancia = codigoImportancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contribuyente> getContribuyentes() {
        return contribuyentes;
    }

    public void setContribuyentes(List<Contribuyente> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }
}
