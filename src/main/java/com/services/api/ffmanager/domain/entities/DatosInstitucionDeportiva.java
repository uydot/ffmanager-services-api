// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="datos_institucion_deportiva")
public class DatosInstitucionDeportiva implements Serializable {

   

    @Id
    @Column(name="id_datos_institucion_deportiva", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDatosInstitucionDeportiva;
    @Column(nullable=false, length=100)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(nullable=false, length=200)
    private String direccion;
    @Column(name="telefono_contacto", length=45)
    private String telefonoContacto;
    @OneToMany(mappedBy="datosInstitucionDeportiva")
    private Set<Complejos> complejos;

    /** Default constructor. */
    public DatosInstitucionDeportiva() {
        super();
    }

    /**
     * Access method for idDatosInstitucionDeportiva.
     *
     * @return the current value of idDatosInstitucionDeportiva
     */
    public int getIdDatosInstitucionDeportiva() {
        return idDatosInstitucionDeportiva;
    }

    /**
     * Setter method for idDatosInstitucionDeportiva.
     *
     * @param aIdDatosInstitucionDeportiva the new value for idDatosInstitucionDeportiva
     */
    public void setIdDatosInstitucionDeportiva(int aIdDatosInstitucionDeportiva) {
        idDatosInstitucionDeportiva = aIdDatosInstitucionDeportiva;
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
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for telefonoContacto.
     *
     * @return the current value of telefonoContacto
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Setter method for telefonoContacto.
     *
     * @param aTelefonoContacto the new value for telefonoContacto
     */
    public void setTelefonoContacto(String aTelefonoContacto) {
        telefonoContacto = aTelefonoContacto;
    }

    /**
     * Access method for complejos.
     *
     * @return the current value of complejos
     */
    public Set<Complejos> getComplejos() {
        return complejos;
    }

    /**
     * Setter method for complejos.
     *
     * @param aComplejos the new value for complejos
     */
    public void setComplejos(Set<Complejos> aComplejos) {
        complejos = aComplejos;
    }

   


    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdDatosInstitucionDeportiva();
        result = 37*result + i;
        return result;
    }

    

   

}
