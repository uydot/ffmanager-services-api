// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="usuarios")
public class Usuarios implements Serializable {

    /** Primary key. */
    protected static final String PK = "idUsuario";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @Column(name="id_usuario", unique=true, nullable=false, precision=10)
    private int idUsuario;
    @Column(nullable=false, length=45)
    private String usuario;
    @Column(nullable=false, length=32)
    private String password;
    @Column(name="fecha_creacion", nullable=false)
    private LocalDateTime fechaCreacion;
    @Column(nullable=false, length=100)
    private String nombre;
    @Column(nullable=false, length=100)
    private String apellido;
    @Column(length=255)
    private String email;
    @Column(nullable=false, precision=19)
    private long telefono;
    @OneToMany(mappedBy="usuarios")
    private Set<Reservas> reservas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_cargo", nullable=false)
    private Cargos cargos;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_perfil", nullable=false)
    private Perfiles perfiles;

    /** Default constructor. */
    public Usuarios() {
        super();
    }

    /**
     * Access method for idUsuario.
     *
     * @return the current value of idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Setter method for idUsuario.
     *
     * @param aIdUsuario the new value for idUsuario
     */
    public void setIdUsuario(int aIdUsuario) {
        idUsuario = aIdUsuario;
    }

    /**
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for fechaCreacion.
     *
     * @return the current value of fechaCreacion
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Setter method for fechaCreacion.
     *
     * @param aFechaCreacion the new value for fechaCreacion
     */
    public void setFechaCreacion(LocalDateTime aFechaCreacion) {
        fechaCreacion = aFechaCreacion;
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
     * Access method for apellido.
     *
     * @return the current value of apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter method for apellido.
     *
     * @param aApellido the new value for apellido
     */
    public void setApellido(String aApellido) {
        apellido = aApellido;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(long aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for reservas.
     *
     * @return the current value of reservas
     */
    public Set<Reservas> getReservas() {
        return reservas;
    }

    /**
     * Setter method for reservas.
     *
     * @param aReservas the new value for reservas
     */
    public void setReservas(Set<Reservas> aReservas) {
        reservas = aReservas;
    }

    /**
     * Access method for cargos.
     *
     * @return the current value of cargos
     */
    public Cargos getCargos() {
        return cargos;
    }

    /**
     * Setter method for cargos.
     *
     * @param aCargos the new value for cargos
     */
    public void setCargos(Cargos aCargos) {
        cargos = aCargos;
    }

    /**
     * Access method for perfiles.
     *
     * @return the current value of perfiles
     */
    public Perfiles getPerfiles() {
        return perfiles;
    }

    /**
     * Setter method for perfiles.
     *
     * @param aPerfiles the new value for perfiles
     */
    public void setPerfiles(Perfiles aPerfiles) {
        perfiles = aPerfiles;
    }

    /**
     * Compares the key for this instance with another Usuarios.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Usuarios and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Usuarios)) {
            return false;
        }
        Usuarios that = (Usuarios) other;
        if (this.getIdUsuario() != that.getIdUsuario()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Usuarios.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Usuarios)) return false;
        return this.equalKeys(other) && ((Usuarios)other).equalKeys(this);
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
        i = getIdUsuario();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Usuarios |");
        sb.append(" idUsuario=").append(getIdUsuario());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idUsuario", Integer.valueOf(getIdUsuario()));
        return ret;
    }

}
