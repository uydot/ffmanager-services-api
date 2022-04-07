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

@Entity(name="materiales")
public class Materiales implements Serializable {


    @Id
    @Column(name="id_material", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterial;
    @Column(nullable=false, length=255)
    private String nombre;
    @Column(nullable=false, precision=10)
    private int stock;
    @Column(name="maximo_por_dia", nullable=false, precision=10)
    private int maximoPorDia;
    @Column(length=255)
    private String observaciones;
    @OneToMany(mappedBy="materiales")
    private Set<MaterialesDeReserva> materialesDeReserva;

    /** Default constructor. */
    public Materiales() {
        super();
    }

    /**
     * Access method for idMaterial.
     *
     * @return the current value of idMaterial
     */
    public int getIdMaterial() {
        return idMaterial;
    }

    /**
     * Setter method for idMaterial.
     *
     * @param aIdMaterial the new value for idMaterial
     */
    public void setIdMaterial(int aIdMaterial) {
        idMaterial = aIdMaterial;
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
     * Access method for stock.
     *
     * @return the current value of stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setter method for stock.
     *
     * @param aStock the new value for stock
     */
    public void setStock(int aStock) {
        stock = aStock;
    }

    /**
     * Access method for maximoPorDia.
     *
     * @return the current value of maximoPorDia
     */
    public int getMaximoPorDia() {
        return maximoPorDia;
    }

    /**
     * Setter method for maximoPorDia.
     *
     * @param aMaximoPorDia the new value for maximoPorDia
     */
    public void setMaximoPorDia(int aMaximoPorDia) {
        maximoPorDia = aMaximoPorDia;
    }

    /**
     * Access method for observaciones.
     *
     * @return the current value of observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Setter method for observaciones.
     *
     * @param aObservaciones the new value for observaciones
     */
    public void setObservaciones(String aObservaciones) {
        observaciones = aObservaciones;
    }

    /**
     * Access method for materialesDeReserva.
     *
     * @return the current value of materialesDeReserva
     */
    public Set<MaterialesDeReserva> getMaterialesDeReserva() {
        return materialesDeReserva;
    }

    /**
     * Setter method for materialesDeReserva.
     *
     * @param aMaterialesDeReserva the new value for materialesDeReserva
     */
    public void setMaterialesDeReserva(Set<MaterialesDeReserva> aMaterialesDeReserva) {
        materialesDeReserva = aMaterialesDeReserva;
    }

   
}
