// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="materiales_de_reserva")
public class MaterialesDeReserva implements Serializable {


    @Id
    @Column(name="id_material_reserva", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterialReserva;
    @Column(nullable=false, precision=10)
    private int cantidad;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_material", nullable=false)
    private Materiales materiales;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public MaterialesDeReserva() {
        super();
    }

    /**
     * Access method for idMaterialReserva.
     *
     * @return the current value of idMaterialReserva
     */
    public int getIdMaterialReserva() {
        return idMaterialReserva;
    }

    /**
     * Setter method for idMaterialReserva.
     *
     * @param aIdMaterialReserva the new value for idMaterialReserva
     */
    public void setIdMaterialReserva(int aIdMaterialReserva) {
        idMaterialReserva = aIdMaterialReserva;
    }

    /**
     * Access method for cantidad.
     *
     * @return the current value of cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter method for cantidad.
     *
     * @param aCantidad the new value for cantidad
     */
    public void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    /**
     * Access method for materiales.
     *
     * @return the current value of materiales
     */
    public Materiales getMateriales() {
        return materiales;
    }

    /**
     * Setter method for materiales.
     *
     * @param aMateriales the new value for materiales
     */
    public void setMateriales(Materiales aMateriales) {
        materiales = aMateriales;
    }

    /**
     * Access method for reservas.
     *
     * @return the current value of reservas
     */
    public Reservas getReservas() {
        return reservas;
    }

    /**
     * Setter method for reservas.
     *
     * @param aReservas the new value for reservas
     */
    public void setReservas(Reservas aReservas) {
        reservas = aReservas;
    }

}
