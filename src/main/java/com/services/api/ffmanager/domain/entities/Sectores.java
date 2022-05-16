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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="sectores")
public class Sectores implements Serializable {


    @Id
    @Column(name="id_sector", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSector;
    @Column(nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(name="tamaño", precision=22)
    private Double tamano;
    @Column(name="es_sector_golero", nullable=false, length=1)
    private Boolean esSectorGolero;
    @Column(name="numero_sector", nullable=false, precision=10)
    private Integer numeroSector;
    @OneToMany(mappedBy="sectores")
    private Set<EstadosDeSectores> estadosDeSectores;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @OneToMany(mappedBy="sectores")
    private Set<ReservaDeSector> reservaDeSector;
    
    private Integer idEstadoSector;
    
    private Boolean sePuedeUtilizar;
    
    private String color;
    
    private String usuarioReserva;

    public String getUsuarioReserva() {
		return usuarioReserva;
	}

	public void setUsuarioReserva(String usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}

	public Boolean getEsSectorGolero() {
		return esSectorGolero;
	}

	/** Default constructor. */
    public Sectores() {
        super();
    }

    /**
     * Access method for idSector.
     *
     * @return the current value of idSector
     */
    public int getIdSector() {
        return idSector;
    }

    /**
     * Setter method for idSector.
     *
     * @param aIdSector the new value for idSector
     */
    public void setIdSector(int aIdSector) {
        idSector = aIdSector;
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
     * Access method for tamano.
     *
     * @return the current value of tamano
     */
    public Double getTamano() {
        return tamano;
    }

    /**
     * Setter method for tamano.
     *
     * @param aTamano the new value for tamano
     */
    public void setTamano(Double aTamano) {
        tamano = aTamano;
    }

    /**
     * Access method for esSectorGolero.
     *
     * @return true if and only if esSectorGolero is currently true
     */
    public Boolean isEsSectorGolero() {
        return esSectorGolero;
    }

    /**
     * Setter method for esSectorGolero.
     *
     * @param aEsSectorGolero the new value for esSectorGolero
     */
    public void setEsSectorGolero(Boolean aEsSectorGolero) {
        esSectorGolero = aEsSectorGolero;
    }

    /**
     * Access method for numeroSector.
     *
     * @return the current value of numeroSector
     */
    public Integer getNumeroSector() {
        return numeroSector;
    }

    /**
     * Setter method for numeroSector.
     *
     * @param aNumeroSector the new value for numeroSector
     */
    public void setNumeroSector(Integer aNumeroSector) {
        numeroSector = aNumeroSector;
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

    /**
     * Access method for areas.
     *
     * @return the current value of areas
     */
    public Areas getAreas() {
        return areas;
    }

    /**
     * Setter method for areas.
     *
     * @param aAreas the new value for areas
     */
    public void setAreas(Areas aAreas) {
        areas = aAreas;
    }

    /**
     * Access method for reservaDeSector.
     *
     * @return the current value of reservaDeSector
     */
    public Set<ReservaDeSector> getReservaDeSector() {
        return reservaDeSector;
    }

    /**
     * Setter method for reservaDeSector.
     *
     * @param aReservaDeSector the new value for reservaDeSector
     */
    public void setReservaDeSector(Set<ReservaDeSector> aReservaDeSector) {
        reservaDeSector = aReservaDeSector;
    }

	public Integer getIdEstadoSector() {
		return idEstadoSector;
	}

	public void setIdEstadoSector(Integer idEstadoSector) {
		this.idEstadoSector = idEstadoSector;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getSePuedeUtilizar() {
		return sePuedeUtilizar;
	}

	public void setSePuedeUtilizar(Boolean sePuedeUtilizar) {
		this.sePuedeUtilizar = sePuedeUtilizar;
	}

  
}
