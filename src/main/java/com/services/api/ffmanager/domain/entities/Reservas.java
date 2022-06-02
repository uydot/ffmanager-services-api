// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="reservas")
public class Reservas implements Serializable {


    @Id
    @Column(name="id_reserva", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    @Column(name="fecha_desde")
    private LocalDateTime fechaDesde;
    @Column(name="fecha_hasta")
    private LocalDateTime fechaHasta;
//    @OneToMany(mappedBy="reservas")
//    private Set<ReservaDeArea> reservaDeArea;
    @OneToMany(mappedBy="reservas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ActividadesDeReserva> actividadesDeReserva;
    @OneToMany(mappedBy="reservas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MaterialesDeReserva> materialesDeReserva;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_usuario", nullable=false)
    private Usuarios usuarios;
    @OneToMany(mappedBy="reservas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReservaDeSector> reservaDeSector;
    @Column(name="usuario_reserva")
    private String usuarioReserva;
    
    public String getUsuarioReserva() {
		return usuarioReserva;
	}

	public void setUsuarioReserva(String usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}

	/** Default constructor. */
    public Reservas() {
        super();
    }

    /**
     * Access method for idReserva.
     *
     * @return the current value of idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Setter method for idReserva.
     *
     * @param aIdReserva the new value for idReserva
     */
    public void setIdReserva(int aIdReserva) {
        idReserva = aIdReserva;
    }

    /**
     * Access method for fechaDesde.
     *
     * @return the current value of fechaDesde
     */
    public LocalDateTime getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Setter method for fechaDesde.
     *
     * @param aFechaDesde the new value for fechaDesde
     */
    public void setFechaDesde(LocalDateTime aFechaDesde) {
        fechaDesde = aFechaDesde;
    }

    /**
     * Access method for fechaHasta.
     *
     * @return the current value of fechaHasta
     */
    public LocalDateTime getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Setter method for fechaHasta.
     *
     * @param aFechaHasta the new value for fechaHasta
     */
    public void setFechaHasta(LocalDateTime aFechaHasta) {
        fechaHasta = aFechaHasta;
    }

//    /**
//     * Access method for reservaDeArea.
//     *
//     * @return the current value of reservaDeArea
//     */
//    public Set<ReservaDeArea> getReservaDeArea() {
//        return reservaDeArea;
//    }
//
//    /**
//     * Setter method for reservaDeArea.
//     *
//     * @param aReservaDeArea the new value for reservaDeArea
//     */
//    public void setReservaDeArea(Set<ReservaDeArea> aReservaDeArea) {
//        reservaDeArea = aReservaDeArea;
//    }

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

    /**
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Usuarios aUsuarios) {
        usuarios = aUsuarios;
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

   
}
