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

@Entity(name="perfiles")
public class Perfiles implements Serializable {

   

    @Id
    @Column(name="id_perfil", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    @Column(nullable=false, length=45)
    private String nombre;
    @Column(name="es_admin", nullable=false, length=1)
    private boolean esAdmin;
    @OneToMany(mappedBy="perfiles")
    private Set<ItemsDePerfiles> itemsDePerfiles;
    @OneToMany(mappedBy="perfiles")
    private Set<Usuarios> usuarios;

    /** Default constructor. */
    public Perfiles() {
        super();
    }

    /**
     * Access method for idPerfil.
     *
     * @return the current value of idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * Setter method for idPerfil.
     *
     * @param aIdPerfil the new value for idPerfil
     */
    public void setIdPerfil(int aIdPerfil) {
        idPerfil = aIdPerfil;
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
     * Access method for esAdmin.
     *
     * @return true if and only if esAdmin is currently true
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Setter method for esAdmin.
     *
     * @param aEsAdmin the new value for esAdmin
     */
    public void setEsAdmin(boolean aEsAdmin) {
        esAdmin = aEsAdmin;
    }

    /**
     * Access method for itemsDePerfiles.
     *
     * @return the current value of itemsDePerfiles
     */
    public Set<ItemsDePerfiles> getItemsDePerfiles() {
        return itemsDePerfiles;
    }

    /**
     * Setter method for itemsDePerfiles.
     *
     * @param aItemsDePerfiles the new value for itemsDePerfiles
     */
    public void setItemsDePerfiles(Set<ItemsDePerfiles> aItemsDePerfiles) {
        itemsDePerfiles = aItemsDePerfiles;
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
