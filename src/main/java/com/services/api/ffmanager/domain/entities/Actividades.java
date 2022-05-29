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

@Entity(name="actividades")
public class Actividades implements Serializable {

   

    @Id
    @Column(name="id_actividad", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;
    @Column(nullable=false, length=45)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(precision=10)
    private int duracion;
    @OneToMany(mappedBy="actividades")
    private Set<ActividadesDeReserva> actividadesDeReserva;
    public boolean isEsDefecto() {
		return esDefecto;
	}

	public void setEsDefecto(boolean esDefecto) {
		this.esDefecto = esDefecto;
	}

	@Column(name="es_defecto", nullable=false, length=1)
    private boolean esDefecto;

    /** Default constructor. */
    public Actividades() {
        super();
    }

    /**
     * Access method for idActividad.
     *
     * @return the current value of idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * Setter method for idActividad.
     *
     * @param aIdActividad the new value for idActividad
     */
    public void setIdActividad(int aIdActividad) {
        idActividad = aIdActividad;
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
     * Access method for duracion.
     *
     * @return the current value of duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Setter method for duracion.
     *
     * @param aDuracion the new value for duracion
     */
    public void setDuracion(int aDuracion) {
        duracion = aDuracion;
    }

    /**
     * Access method for actividadesDeReserva.
     *
     * @return the current value of actividadesDeReserva
     */
    public Set<ActividadesDeReserva> getActividadesDeReserva() {
        return actividadesDeReserva;
    }

    /**
     * Setter method for actividadesDeReserva.
     *
     * @param aActividadesDeReserva the new value for actividadesDeReserva
     */
    public void setActividadesDeReserva(Set<ActividadesDeReserva> aActividadesDeReserva) {
        actividadesDeReserva = aActividadesDeReserva;
    }


}
