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

@Entity(name="estados")
public class Estados implements Serializable {


    @Id
    @Column(name="id_estado", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;
    @Column(nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(name="permite_usar", nullable=false, length=1)
    private boolean permiteUsar;
    @OneToMany(mappedBy="estados")
    private Set<EstadosDeAreas> estadosDeAreas;
    @OneToMany(mappedBy="estados")
    private Set<EstadosDeSectores> estadosDeSectores;
    @Column(name="color")
    private String color;
    @Column(name="indica_reserva")
    private Boolean indicaReserva;

    public Boolean isIndicaReserva() {
		return indicaReserva;
	}

	public void setIndicaReserva(Boolean indicaReserva) {
		this.indicaReserva = indicaReserva;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/** Default constructor. */
    public Estados() {
        super();
    }

    /**
     * Access method for idEstado.
     *
     * @return the current value of idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Setter method for idEstado.
     *
     * @param aIdEstado the new value for idEstado
     */
    public void setIdEstado(int aIdEstado) {
        idEstado = aIdEstado;
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
     * Access method for permiteUsar.
     *
     * @return true if and only if permiteUsar is currently true
     */
    public boolean isPermiteUsar() {
        return permiteUsar;
    }

    /**
     * Setter method for permiteUsar.
     *
     * @param aPermiteUsar the new value for permiteUsar
     */
    public void setPermiteUsar(boolean aPermiteUsar) {
        permiteUsar = aPermiteUsar;
    }

    /**
     * Access method for estadosDeAreas.
     *
     * @return the current value of estadosDeAreas
     */
    public Set<EstadosDeAreas> getEstadosDeAreas() {
        return estadosDeAreas;
    }

    /**
     * Setter method for estadosDeAreas.
     *
     * @param aEstadosDeAreas the new value for estadosDeAreas
     */
    public void setEstadosDeAreas(Set<EstadosDeAreas> aEstadosDeAreas) {
        estadosDeAreas = aEstadosDeAreas;
    }

    /**
     * Access method for estadosDeSectores.
     *
     * @return the current value of estadosDeSectores
     */
    public Set<EstadosDeSectores> getEstadosDeSectores() {
        return estadosDeSectores;
    }

    /**
     * Setter method for estadosDeSectores.
     *
     * @param aEstadosDeSectores the new value for estadosDeSectores
     */
    public void setEstadosDeSectores(Set<EstadosDeSectores> aEstadosDeSectores) {
        estadosDeSectores = aEstadosDeSectores;
    }

}
