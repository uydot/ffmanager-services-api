// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="cargos")
public class Cargos implements Serializable {

    @Id
    @Column(name="id_cargo", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCargo;
    @Column(nullable=false, length=45)
    private String nombre;
    @OneToMany(mappedBy="cargos")
    private Set<Usuarios> usuarios;

    /** Default constructor. */
    public Cargos() {
        super();
    }

    /**
     * Access method for idCargo.
     *
     * @return the current value of idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * Setter method for idCargo.
     *
     * @param aIdCargo the new value for idCargo
     */
    public void setIdCargo(int aIdCargo) {
        idCargo = aIdCargo;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Set<Usuarios> aUsuarios) {
        usuarios = aUsuarios;
    }

}
